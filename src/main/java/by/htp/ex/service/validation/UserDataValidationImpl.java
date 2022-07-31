package by.htp.ex.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import by.htp.ex.bean.NewUserInfo;

public class UserDataValidationImpl implements UserDataValidation {
	private final static String regLogin = "^[a-zA-Z]{3,16}";
	private final static String regPassword = "^(?=.*[A-Z].*[A-Z])(?=.*[!@#$&*])(?=.*[0-9].*[0-9])(?=.*[a-z].*[a-z].*[a-z]).{8,}$";
	private final static String regEmail = "^(.+)@(.+)$";
	
	private List<String> incorrectData = new ArrayList<String>();
	
	@Override
	public boolean checkLogin(String login) {
		
		if(Pattern.compile(regLogin).matcher(login).matches()) {
			System.out.println("checkLogin = true");
			return true;
		}
		else {
			System.out.println("checkLogin = false");
			incorrectData.add("incorrectLogin");
		return false;
		}
	}

	@Override
	public boolean checkPassword(String password) {
		if(Pattern.compile(regPassword).matcher(password).matches()) {
			System.out.println("checkPassword = true");
			return true;
		}
		else {
			System.out.println("checkPassword = false");
			incorrectData.add("incorrectPassword");
		return false;
		}
	}
	
	public boolean checkPasswordAndConfirmPassword(String password, String confirmPassword) {
		if (password.equals(confirmPassword)) {
			
		return checkPassword(password);
		
		}
		else {
			incorrectData.add("PasswordNotEqualsConfirmPassword");
			return false;
		}
	}
	
	public boolean checkEmail(String email) {
		if(Pattern.compile(regEmail).matcher(email).matches()) {
			System.out.println("checkEmail = true");
			return true;
		}
		else {
			incorrectData.add("incorrectEmail");
			System.out.println("checkEmail = false");
		return false;
		}
	}

	@Override
	public boolean checkRegistration(NewUserInfo user) {
		if(checkLogin(user.getLogin()) && checkPasswordAndConfirmPassword(user.getPassword(), user.getConfirmPassword()) && checkEmail(user.getEmail())){
			return true;
		}		
		else {
			
			//System.out.println("checkRegistration" + incorrectData.toString()); ///????
		return false;
		}
	}


	public List<String> getIncorrectData(){
		return incorrectData;
	}
}
