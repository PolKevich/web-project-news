package by.htp.ex.service;

public class ServiceException extends Exception {
	
	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String massage) {
		super(massage);
	}

}
