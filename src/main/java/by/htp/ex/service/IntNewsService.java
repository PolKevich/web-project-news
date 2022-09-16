package by.htp.ex.service;

import java.util.List;

import by.htp.ex.bean.News;

public interface IntNewsService {

	boolean save(News news) throws ServiceException;

	void update(News news) throws ServiceException;

	void delete(String[] idNewses) throws ServiceException;

	List<News> latestList(int count) throws ServiceException;

	List<News> list(Integer pageNumber, String newsCountOnPage) throws ServiceException;

	News findById(int id) throws ServiceException;

	List<Integer> getPage();

}
