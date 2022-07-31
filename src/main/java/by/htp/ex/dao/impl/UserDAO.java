package by.htp.ex.dao.impl;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IntUserDao;

public class UserDAO implements IntUserDao {

	@Override
	public boolean logination(String login, String password) throws DaoException {
		
	//	return true;
		return false;
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getRole(String login, String password) throws DaoException {
		// return "user";
		return "admin";
	}

}
