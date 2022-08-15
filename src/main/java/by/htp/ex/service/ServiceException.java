package by.htp.ex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.htp.ex.dao.DaoException;

public class ServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, String> listMassage = new HashMap();
	
	public ServiceException(Exception e) {
		super(e);
	}
	
	public ServiceException(String massage) {
		super(massage);
	}
	
	public ServiceException(String massage, Exception e ) {
		super(massage, e);
	}
	
	public ServiceException(String key, String value) {

		listMassage.put(key, value);
	}
	
	public ServiceException(Map<String, String> massage) {
		
		listMassage.putAll(massage);
	}

	public Map<String, String> getListMassage() {
		return listMassage;
	}
	
	public void clearListMassage() {
		listMassage.clear();
		DaoException.clearListMassage();
	}

}
