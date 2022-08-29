package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.htp.ex.bean.News;
import by.htp.ex.dao.IntNewsDAO;
import by.htp.ex.dao.NewsDAOException;
import by.htp.ex.dao.conPool.ConnectionPool;
import by.htp.ex.dao.conPool.ConnectionPoolException;

public class NewsDAO implements IntNewsDAO {

	private static final String sqlGetList = "SELECT * FROM news";

	@Override
	public List<News> getList() throws NewsDAOException {

		List<News> result = new ArrayList<News>();

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlGetList)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				News news = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));

				result.add(news);
			}

			return result;

		} catch (ConnectionPoolException | SQLException e) {

			throw new NewsDAOException(e);
		}

	}

	@Override
	public List<News> getLatestsList(int count) throws NewsDAOException {

		String sqlGetLatesNews = "SELECT * FROM news LIMIT " + count;

		List<News> result = new ArrayList<News>();

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlGetLatesNews)) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				News news = new News(rs.getInt("id"), rs.getString("title"), rs.getString("brief"),
						rs.getString("content"), rs.getString("data"));

				result.add(news);

			}

			return result;

		} catch (ConnectionPoolException | SQLException e) {

			throw new NewsDAOException(e);
		}

	}

	public static final String sqlGetNews = "SELECT * FROM news where id=?";

	@Override
	public News findById(int id) throws NewsDAOException {

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlGetNews)) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			rs.next();

			return new News(rs.getInt("id"), rs.getString("title"), rs.getString("brief"), rs.getString("content"),
					rs.getString("data"));

		} catch (ConnectionPoolException | SQLException e) {

			throw new NewsDAOException(e);
		}

	}

	private static final String sqlAddNews = "INSERT INTO news(title, brief, content, data, "
			+ "reporter_id) VALUE(?,?,?,?,?)";

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

				throw new NewsDAOException("News not saved.");
			}

		} catch (ConnectionPoolException | SQLException e) {

			throw new NewsDAOException("News not saved.");

		}

		return rezAddNews;
	}

	private static final String sqlUpdateNews = "UPDATE news SET title=?, brief=?,content=?,data=?,reporter_id=? WHERE id=?";

	@Override
	public void updateNews(News news) throws NewsDAOException {

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlUpdateNews)) {

			ps.setString(1, news.getTitle());
			ps.setString(2, news.getBriefNews());
			ps.setString(3, news.getContent());
			ps.setString(4, news.getNewsDate());
			ps.setInt(5, 1);
			ps.setInt(6, news.getIdNews());

			ps.executeUpdate();

		} catch (SQLException | ConnectionPoolException e) {

			throw new NewsDAOException("News not update.");

		}

	}

	public static final String sqlDelNews = "DELETE  FROM news where id=?";

	@Override
	public void deleteNewses(String[] idNewses) throws NewsDAOException {

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlDelNews)) {

			for (String id : idNewses) {

				ps.setInt(1, Integer.parseInt(id));
				ps.executeUpdate();
			}

		} catch (ConnectionPoolException | SQLException e) {

			throw new NewsDAOException("News not delete.");

		}
	}

}
