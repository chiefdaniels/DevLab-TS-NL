package nl.watershare.common.security;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Properties;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderSAX2Factory;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * An external session id (+ user id and country id) is expected as a request
 * parm on a new session in this application. The external session id is
 * validated by a call to the external application. Once a session is accepted
 * no further external validation is done during its life cycle. Only one
 * session may be active per external session (id). This is checked. If a new
 * session is coupled to an external session, the old session coupled to the
 * same external session will be invalidated on the next request.
 */
public class SessionValidationFilter implements Filter {

	private static Logger LOG = LoggerFactory.getLogger(SessionValidationFilter.class);

	private static final String EXTERNAL_SESSION_ID = "external-session-id";
	private static final String USER_ID = "user-id";
	private static final String COUNTRY_ID = "country-id";

	private static final String SESSION_VALIDATION = "sessionValidation";
	private static final String EXTERNAL_SESSION_VALIDATION_URL = "externalSession.validation.url";
	private static final String SESSION_INVALID_REDIRECT_URL = "session.invalid.redirect.url";
	private static final String EXTERNAL_SESSION_VALIDATION_TURNEDON = "externalSession.validation.turnedOn";

	private static final String RETURN_CODE_VALID = "1";
	private static final String UTF_8 = "UTF-8";

	private volatile String externalSessionValidationUrl;
	private volatile String redirectUrl;
	private volatile boolean turnedOn;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		LOG.debug("init(...)");
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
		Properties properties = applicationContext.getBean(SESSION_VALIDATION, Properties.class);
		externalSessionValidationUrl = properties.getProperty(EXTERNAL_SESSION_VALIDATION_URL);
		redirectUrl = properties.getProperty(SESSION_INVALID_REDIRECT_URL);
		turnedOn = Boolean.parseBoolean(properties.getProperty(EXTERNAL_SESSION_VALIDATION_TURNEDON));
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		LOG.debug("doFilter(...)");

		boolean doFilter = true;
		if (turnedOn) {
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			HttpSession httpSession = httpServletRequest.getSession();
			doFilter = doSessionValidation(httpServletRequest, httpServletResponse, httpSession);
		}

		if (doFilter) {
			chain.doFilter(request, response);
		}
	}

	private boolean doSessionValidation(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, HttpSession httpSession) throws IOException {
		String externalSessionIdRequest = httpServletRequest.getParameter(EXTERNAL_SESSION_ID);
		String userIdRequest = httpServletRequest.getParameter(USER_ID);
		String countryIdRequest = httpServletRequest.getParameter(COUNTRY_ID);
		boolean validSession = false;

		// Check if external session id parameter is present
		if (externalSessionIdRequest != null) {
			// External session ID parameter present
			boolean valid = isExternalSessionIdValid(externalSessionIdRequest, userIdRequest, countryIdRequest);
			if (valid) {
				// Register the external session id on the internal session id
				SessionRegistry.coupleSession(httpSession.getId(), externalSessionIdRequest);
				validSession = true;
			}
		} else if (isSessionValid(httpSession)) {
			validSession = true;
		}

		if (!validSession) {
			inValidateAndRedirect(httpServletResponse, httpSession);
		}
		return validSession;
	}

	private void inValidateAndRedirect(HttpServletResponse httpServletResponse, HttpSession httpSession) throws IOException {
		// invalidate and redirect
		LOG.info("invalidate and redirect");
		httpSession.invalidate();
		httpServletResponse.sendRedirect(redirectUrl);
	}

	/**
	 * session id must map to an external session-id
	 */
	private boolean isSessionValid(HttpSession session) {
		boolean sessionValid = SessionRegistry.isSessionValid(session.getId());
		LOG.debug("isSessionValid(...) return: " + sessionValid);
		return sessionValid;
	}

	/**
	 * call to external app to validate external session id
	 */
	private boolean isExternalSessionIdValid(String externalSessionId, String userIdRequest, String countryIdRequest) {
		LOG.debug("isExternalSessionIdValid([" + externalSessionId + "], [" + userIdRequest + "], [" + countryIdRequest + "])");
		URL portalUrl;
		try {
			String urlString = String.format(externalSessionValidationUrl, URLEncoder.encode(externalSessionId, UTF_8), URLEncoder.encode(userIdRequest, UTF_8), URLEncoder.encode(countryIdRequest, UTF_8));
			LOG.debug("isExternalSessionIdValid(...) urlString: " + urlString);
			portalUrl = new URL(urlString);
			URLConnection urlConnectionPortal = portalUrl.openConnection();
			InputStream inputStream = urlConnectionPortal.getInputStream();

			// parse and analyze
			SAXBuilder builder = new SAXBuilder(new XMLReaderSAX2Factory(false));
			Document document = builder.build(inputStream);

			XPathExpression<Element> xpath = XPathFactory.instance().compile("/session/isloggedin", Filters.element());
			Element emt = xpath.evaluateFirst(document);

			boolean valid = emt != null && RETURN_CODE_VALID.equals(emt.getText());

			LOG.info("isExternalSessionIdValid([" + externalSessionId + "]), return: " + valid);
			return valid;
		} catch (Throwable e) {
			LOG.error("isExternalSessionIdValid([" + externalSessionId + "])", e);
		}
		return false;
	}

	@Override
	public void destroy() {
		LOG.debug("destroy()");
	}

}
