package by.htp.ex.controller.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.htp.ex.dao.conPool.ConnectionPool;
import by.htp.ex.dao.conPool.ConnectionPoolException;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class StartPoolWithListener implements ServletContextListener {

	private static final Logger log = LogManager.getRootLogger();

	public void contextInitialized(ServletContextEvent ev) {

		try {

			ConnectionPool.getInstance();

		} catch (ConnectionPoolException e) {

			log.error(e);
			throw new RuntimeException("Connection error with ConnectionPool.");
		}

	}

	public void contextDestroyed(ServletContextEvent ev) {

		try {

			ConnectionPool.getInstance().dispose();

		} catch (ConnectionPoolException e) {

			log.error(e);
			throw new RuntimeException("Disconnect error with ConnectionPool.");
		}

	}

}
