package by.htp.ex.service.validation;

public interface UserDataValidation {
	
	boolean checkName(String name); // ����� �� ����-�� exception, ��� ����� true ��� false
	
	boolean checkPassword(String password);

}
