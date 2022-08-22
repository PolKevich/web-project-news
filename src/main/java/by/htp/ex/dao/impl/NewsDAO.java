package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.bean.News;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IntNewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.dao.conPool.ConnectionPool;
import by.htp.ex.dao.conPool.ConnectionPoolException;

public class NewsDAO implements IntNewsDAO {
	
	private static final String sqlAddNews = "INSERT INTO news(title, brief, content, data, "
			+ "reporter_id) VALUE(?,?,?,?,?)";
	

	@Override
	public List<News> getList() throws NewsDAOException {
		
		String sqlGetNews = "SELECT * FROM news";
		
		List<News> result = new ArrayList<News>();

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlGetNews)) {
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				News news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));

				result.add(news);
			}
			
			return result;
			
		}catch (ConnectionPoolException | SQLException e) {
			
			throw new NewsDAOException(e);
		}

	}

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException {
		
		String sqlGetNews = "SELECT * FROM news LIMIT " + count;
		
		List<News> result = new ArrayList<News>();
				
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlGetNews)) {
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				News news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));

				result.add(news);
				
			}
			
			return result;
			
		}catch (ConnectionPoolException | SQLException e) {
			
			throw new NewsDAOException(e);
		}

	}

	@Override
	public News fetchById(int id) throws NewsDAOException {
		
		String sqlGetNews = "SELECT * FROM news LIMIT " + id;
		
		News news = null;
		
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlGetNews)) {
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5));
				
			}
			
			return news;
			
		}catch (ConnectionPoolException | SQLException e) {
			
			throw new NewsDAOException(e);
		}


	}

	@Override
	public int addNews(News news) throws NewsDAOException {
				
		int rezAddNews = 0;
			
		
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlAddNews)) {
			
			ps.setString(1, news.getTitle());
			ps.setString(2, news.getBriefNews());
			ps.setString(3, news.getContent());
			ps.setString(4, news.getNewsDate());
			ps.setInt(5, 1);
			
			rezAddNews = ps.executeUpdate();
			
					
			if (rezAddNews == 0) {
				
				throw new NewsDAOException("News not saved");
			}
			
			
		} catch (ConnectionPoolException | SQLException e) {
			
			throw new NewsDAOException("News not saved");

		} 
		
		return rezAddNews;
	}

	@Override
	public void updateNews(News news) throws NewsDAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNewses(String[] idNewses) throws NewsDAOException {
		// TODO Auto-generated method stub
		
	}

}
