package by.htp.ex.dao;

import by.htp.ex.bean.NewUserInfo;

public interface IntUserDao {

	boolean logination(String login, String password) throws DaoException;

	boolean registration(NewUserInfo user) throws DaoException;

	String role(String login, String password) throws DaoException;

}
