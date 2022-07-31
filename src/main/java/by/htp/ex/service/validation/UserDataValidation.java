package by.htp.ex.service.validation;

import java.util.List;

import by.htp.ex.bean.NewUserInfo;

public interface UserDataValidation {
	
	boolean checkLogin(String login); 
	
	boolean checkPassword(String password);
	
	boolean checkRegistration(NewUserInfo user);
	
	List<String> getIncorrectData();

}
