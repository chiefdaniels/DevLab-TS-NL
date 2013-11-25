package nl.watershare.common.security;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Manages a list of all active sessions and their statuses.
 * 
 * A sole instance per application of this object is assumed.
 */
public class SessionRegistry implements HttpSessionListener {

	private static Logger LOG = LoggerFactory.getLogger(SessionRegistry.class);
	/**
	 * Set of all active sessions.
	 */
	private final static NavigableSet<String> sessionSet = new ConcurrentSkipListSet<String>();

	/**
	 * map between internal session ids to external session ids
	 * 
	 * This is really a one to one map. A bidirectional map would be more
	 * appropriate (also for efficiency).
	 */
	private final static ConcurrentNavigableMap<String, String> sessionMap = new ConcurrentSkipListMap<String, String>();

	/**
	 * Lock for write actions on session list objects
	 */
	private final static Object lock = new Object();

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		synchronized (lock) {
			String id = httpSessionEvent.getSession().getId();
			sessionSet.add(id);
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		synchronized (lock) {
			String id = httpSessionEvent.getSession().getId();
			sessionSet.remove(id);
			sessionMap.remove(id);
		}
	}

	public static void coupleSession(String sessionId, String externalSessionId) {
		synchronized (lock) {
			if (sessionSet.contains(sessionId)) {
				sessionMap.put(sessionId, externalSessionId);
				LOG.debug("Sessiondata added to sessionMap, internalSession:" + sessionId + ", externalSession:" + externalSessionId);
			}
		}
	}

	public static boolean isSessionValid(String sessionId) {
		return sessionMap.containsKey(sessionId);
	}
}
