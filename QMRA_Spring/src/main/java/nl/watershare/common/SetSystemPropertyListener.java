package nl.watershare.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class SetSystemPropertyListener implements ServletContextListener {

	static Logger log = Logger.getLogger(SetSystemPropertyListener.class);


	@Override
	public void contextInitialized(ServletContextEvent sce) {
        String rootPath = sce.getServletContext().getRealPath("/");
        System.setProperty("webroot", rootPath);
    }

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}
}