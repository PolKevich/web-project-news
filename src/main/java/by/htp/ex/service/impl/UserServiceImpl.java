package by.htp.ex.service.impl;

import java.util.List;
import java.util.Map;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IntUserDao;
import by.htp.ex.dao.impl.UserDAO;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.IntUserService;
import by.htp.ex.service.validation.UserDataValidation;
import by.htp.ex.service.validation.ValidationProvider;

public class UserServiceImpl implements IntUserService {

	private final IntUserDao userDAO = DaoProvider.getInstance().getUserDao();
	private final UserDataValidation userDataValidation = ValidationProvider.getInstance().getUserDataValidation();
	

	@Override
	public String signIn(String login, String password) throws ServiceException {
		
		/*
		 * if(!userDataValidation.checkAUthData(login, password)) { throw new
		 * ServiceException("login ...... "); }
		 */
		
		try {
			if(userDAO.logination(login, password)) { 
				return userDAO.getRole(login, password);
			}else {
				return "guest";
			}
			
		}catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean registration(NewUserInfo user) throws ServiceException {
					
		try {
		if(userDataValidation.checkRegistration(user)) {
						
			return userDAO.registration(user); 
			
		}			
			return false;
	
		}
		 catch (DaoException e) {
			throw new ServiceException(DaoException.getListMassage());
		}

	}
	
}
