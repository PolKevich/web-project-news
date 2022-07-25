package by.htp.ex.service;

import by.htp.ex.service.impl.NewsServiceImpl;
import by.htp.ex.service.impl.UserServiceImpl;

public class ServiceProvider {
	
	private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private final IntUserService userService = new UserServiceImpl();
	private final IntNewsService newsService = new NewsServiceImpl();
	
	public IntUserService getUserService() {
		return userService;
	}
	
	public IntNewsService getNewsService() {
		return newsService;
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}

}
