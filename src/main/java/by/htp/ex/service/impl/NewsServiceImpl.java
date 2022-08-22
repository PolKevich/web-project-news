package by.htp.ex.service.impl;

import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IntNewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.service.IntNewsService;
import by.htp.ex.service.ServiceException;

public class NewsServiceImpl implements IntNewsService {
	
	private final IntNewsDAO newsDAO = DaoProvider.getInstance().getNewsDAO();

	@Override
	public boolean save(News news) throws NewsDAOException {
		
		boolean save = false;
		
		try {
			if(newsDAO.addNews(news) != 0) {
				
				save = true;		
			}
		} catch (NewsDAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return save;
		
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> latestList(int count) throws ServiceException {
		
		try {
			
			return newsDAO.getLatestsList(count);
			
		} catch (NewsDAOException e) {
			
			throw new ServiceException(e);
		}
	}

	@Override
	public List<News> list() throws ServiceException {
		
		try {
			return newsDAO.getList();
			
		} catch (NewsDAOException e) {
			
			throw new ServiceException(e);
		}
	}

	@Override
	public News findById(int id) throws ServiceException {
		
		try {
			
			return newsDAO.fetchById(id);
			
		} catch (NewsDAOException e) {
			
			throw new ServiceException(e);
		}
	}

}
