package by.htp.ex.service.impl;

import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IntNewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.service.IntNewsService;
import by.htp.ex.service.ServiceException;

public class NewsServiceImpl implements IntNewsService {

	private final IntNewsDAO newsDAO = DaoProvider.getInstance().getNewsDAO();

	@Override
	public boolean save(News news) throws ServiceException {

		boolean save = false;

		try {

			if (newsDAO.addNews(news) != 0) {

				save = true;
			}
		} catch (NewsDAOException e) {

			throw new ServiceException(e);
		}
		return save;

	}

	@Override
	public void update(News news) throws ServiceException {

		try {
			newsDAO.updateNews(news);

		} catch (NewsDAOException e) {

			throw new ServiceException(e);
		}

	}

	@Override
	public void delete(String[] idNewses) throws ServiceException {

		try {
			newsDAO.deleteNewses(idNewses);

		} catch (NewsDAOException e) {

			throw new ServiceException(e);
		}
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

			return newsDAO.findById(id);

		} catch (NewsDAOException e) {

			throw new ServiceException(e);
		}
	}

}
