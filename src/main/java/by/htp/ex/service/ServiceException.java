package by.htp.ex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> listMassage;
	
	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String massage) {
		super(massage);
	}
	
	public ServiceException(String massage, Exception e ) {
		super(massage, e);
	}
	
	public ServiceException(Map<String, String> massage) {
		listMassage = new HashMap();
		listMassage = massage;
	}

	public Map<String, String> getListMassage() {
		return listMassage;
	}

}
