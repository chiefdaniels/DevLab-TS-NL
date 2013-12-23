package nl.watershare.common;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hsqldb.Server;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Component
public class HSQLDBStartupListener implements ServletContextListener {

	static Logger log = Logger.getLogger(HSQLDBStartupListener.class);

	private Server hsqldbServer = null;
	private boolean hsqldbActive = false;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
        
        ServletContext ctx = sce.getServletContext();
		WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(ctx);

		// *** Check Database Name ***
		SessionFactory sessionFactory = (SessionFactory)springContext.getBean("sessionFactory");
		String dbName = null;
		try {
			Session session = sessionFactory.openSession();
			@SuppressWarnings("deprecation")
			DatabaseMetaData md = session.connection().getMetaData();
			dbName = md.getDatabaseProductName();
			if (dbName.contains(new StringBuffer("HSQL"))) {
				hsqldbActive = true;
			}
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// *** Setup HSQLDB server if JDBC-driver is HSQLDB *** 
		if (hsqldbActive) {
			log.info("Starting HSQL server");
			hsqldbServer = new Server();
			hsqldbServer.setTrace(true);
			hsqldbServer.start();
		}
        
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		if (hsqldbActive) {
			log.info("Stopping HSQL server");
			hsqldbServer.stop();
		}
	}
}