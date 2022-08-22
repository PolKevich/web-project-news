package by.htp.ex.service;

import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.NewsDAOException;

public interface IntNewsService {
	
	  boolean save(News news) throws NewsDAOException;
	  void find();
	  void update();
	  
	  List<News> latestList(int count)  throws ServiceException;
	  List<News> list()  throws ServiceException;
	  News findById(int id) throws ServiceException;

}
