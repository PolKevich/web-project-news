package by.htp.ex.dao;

import by.htp.ex.dao.impl.NewsDAO;
import by.htp.ex.dao.impl.UserDAO;

public class DaoProvider {

	private static final DaoProvider instance = new DaoProvider();
	
	private final IntUserDao userDao = new UserDAO();
	private final IntNewsDAO newsDao = new NewsDAO();

	
	private DaoProvider() {
		
	}
	
	public IntUserDao getUserDao() {
		return userDao;
	}
	
	public IntNewsDAO getNewsDAO() {
		return newsDao;
		
	}
	
	public static DaoProvider getInstance() {
		return instance;
	}
}
