package by.htp.ex.controller.listener;


import by.htp.ex.dao.conPool.ConnectionPool;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class StartPoolWithListener implements ServletContextListener  {
	
	// Logger
	
	public void contextInitialized(ServletContextEvent ev) {
			
		ConnectionPool.getInstance(); 
		
	}
	
	public void contextDestroyed(ServletContextEvent ev) {
		
		ConnectionPool.getInstance().dispose();
		
	}

}
