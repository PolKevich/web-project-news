package by.htp.ex.dao;

import java.util.List;

import by.htp.ex.bean.News;

public interface IntNewsDAO {

	List<News> getList() throws NewsDAOException;

	List<News> getLatestsList(int count) throws NewsDAOException;

	News findById(int id) throws NewsDAOException;

	int addNews(News news) throws NewsDAOException;

	void updateNews(News news) throws NewsDAOException;

	void deleteNewses(String[] idNewses) throws NewsDAOException;

}
