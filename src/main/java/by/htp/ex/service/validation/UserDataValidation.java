package by.htp.ex.service.validation;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.service.ServiceException;

public interface UserDataValidation {

	boolean checkLogin(String login) throws ServiceException;

	boolean checkPassword(String password) throws ServiceException;

	boolean checkRegistration(NewUserInfo user) throws ServiceException;

}
