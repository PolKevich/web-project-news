package by.htp.ex.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.ex.bean.News;
import by.htp.ex.dao.DaoProvider;
import by.htp.ex.dao.IntNewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.service.IntNewsService;
import by.htp.ex.service.ServiceException;

public class NewsServiceImpl implements IntNewsService {

	private final IntNewsDAO newsDAO = DaoProvider.getInstance().getNewsDAO();
	
	private List<Integer> pageCount;

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
	public List<News> list(Integer pageNumber, String newsCountOnPage) throws ServiceException {
		
		String newsCount = "4";
		
		if (newsCountOnPage != null) {
			
			newsCount = newsCountOnPage;
		}

		try {
			List<News> allNewsList = newsDAO.getList();
			
			pageCount = createPageCountList(allNewsList, newsCount);
			
			return getNewsOnPage(allNewsList, pageNumber, newsCount);

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
	
	private List<Integer> createPageCountList(List<News> allNewsList, String newsCount) {
		
		double numberNews = Double.parseDouble(newsCount); 
		
		int number = (int) (Math.ceil(allNewsList.size() / numberNews));
		
		List<Integer> pageCount = new ArrayList<Integer>();
		
		for (int i = 1; i <= number; i++) {
			
			pageCount.add(i);
		}
		return pageCount;
		
	}
	
	private List<News> getNewsOnPage(List<News> allNewsList, Integer pageNumber, String newsCount) {
		
		int numberNews = Integer.valueOf(newsCount);
		
		List<News> newsPage = new ArrayList<News>();
		
		if (allNewsList.isEmpty()) {
			return null;
		}
		int beginNews = pageNumber * numberNews - numberNews;
		
		int endNews = pageNumber * numberNews;
		
		if (endNews > allNewsList.size()) {
			
			endNews = allNewsList.size();
		}
		for (int i = beginNews; i < endNews; i++) {
			
			newsPage.add(allNewsList.get(i));
		}
		if (newsPage.isEmpty() && pageNumber > 1) {
			
			return getNewsOnPage(allNewsList, pageNumber - 1, newsCount);
		}
		return newsPage;

	}
	
	@Override
	public List<Integer> getPage() {
		
		return pageCount;
	}

}
