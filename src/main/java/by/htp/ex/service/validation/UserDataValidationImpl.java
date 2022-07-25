package by.htp.ex.service.validation;

public class UserDataValidationImpl implements UserDataValidation {

	@Override
	public boolean checkName(String name) {

		 return false;
	}

	@Override
	public boolean checkPassword(String password) {
		int size = Integer.parseInt(password);
		
		if(size < 5) {
			
			return false;
		}
		 return true;
	}

}
