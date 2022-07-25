package by.htp.ex.service.validation;

public interface UserDataValidation {
	
	boolean checkName(String name); // метод не выбр-ет exception, нам нужен true или false
	
	boolean checkPassword(String password);

}
