package by.htp.ex.service.validation;

import java.util.regex.Pattern;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.service.ServiceException;

public class UserDataValidationImpl implements UserDataValidation {
	private final static String regLogin = "^[a-zA-Z]{3,16}";
	private final static String regPassword = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,}$";
	private final static String regEmail = "^(.+)@(.+)$";

	@Override
	public boolean checkLogin(String login) throws ServiceException {

		boolean checkLogin = true;

		if (!(Pattern.compile(regLogin).matcher(login).matches())) {

			checkLogin = false;
			throw new ServiceException("login", "incorrectLogin!");
		}

		ServiceException.clearListKey("login");
		
		return checkLogin;

	}

	@Override
	public boolean checkPassword(String password) throws ServiceException {

		boolean checkPassword = true;

		if (!(Pattern.compile(regPassword).matcher(password).matches())) {

			checkPassword = false;
			
			throw new ServiceException("password", "incorrectPassword");
		}

		ServiceException.clearListKey("password");
		
		return checkPassword;

	}

	public boolean checkPasswordAndConfirmPassword(String password, String confirmPassword) throws ServiceException {

		if (password.equals(confirmPassword)) {
			
			ServiceException.clearListKey("confirmPassword");

			return checkPassword(password);

		} else {
			
			throw new ServiceException("confirmPassword", "PasswordNotEqualsConfirmPassword");

		}
	}

	public boolean checkEmail(String email) throws ServiceException {

		boolean checkEmail = true;

		if (!(Pattern.compile(regEmail).matcher(email).matches())) {

			checkEmail = false;
			
			throw new ServiceException("email", "incorrectEmail");
		}

		ServiceException.clearListKey("email");
		
		return checkEmail;

	}

	@Override
	public boolean checkRegistration(NewUserInfo user) throws ServiceException {

		boolean checkRegistration = true;

		if (!(checkLogin(user.getLogin())
				
				&& checkPasswordAndConfirmPassword(user.getPassword(), user.getConfirmPassword())
				&& checkEmail(user.getEmail()))) {
			checkRegistration = false;
		}

		return checkRegistration;

	}

}
