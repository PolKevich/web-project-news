package by.htp.ex.service;

import java.util.List;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private List<String> listMassage;
	
	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String massage) {
		super(massage);
	}
	
	public ServiceException(String massage, Exception e ) {
		super(massage, e);
	}
	
	public ServiceException(List<String> massage) {
		listMassage = massage;
	}

	public List<String> getListMassage() {
		return listMassage;
	}

}
