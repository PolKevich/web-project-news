package by.htp.ex.dao;

import java.util.HashMap;
import java.util.Map;

public class DaoException extends Exception {

	private static final long serialVersionUID = 8814453066415187129L;

	private static Map<String, String> listMassage = new HashMap();

	public DaoException() {
		super();
	}

	public DaoException(String massage) {
		super(massage);
	}

	public DaoException(Exception e) {
		super(e);
	}

	public DaoException(String massage, Exception e) {
		super(massage, e);
	}

	public DaoException(String key, String value) {
		listMassage.put(key, value);
	}

	public static Map<String, String> getListMassage() {
		return listMassage;
	}

	public static void clearListKey(String key) {
		listMassage.remove(key);
	}

}
