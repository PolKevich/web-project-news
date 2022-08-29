package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IntUserDao;
import by.htp.ex.dao.conPool.ConnectionPool;
import by.htp.ex.dao.conPool.ConnectionPoolException;

public class UserDAO implements IntUserDao {

	@Override
	public boolean logination(String login, String password) throws DaoException {

		boolean rezLogination = false;

		String sqlUsers = "SELECT* FROM users WHERE login=? AND password=?";

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlUsers)) {

			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				rezLogination = true;
			}

		} catch (ConnectionPoolException | SQLException e) {

			throw new DaoException();
		}

		return rezLogination;
	}

	@Override
	public boolean registration(NewUserInfo user) throws DaoException {

		boolean rezRegistration = false;

		String sqlUsers = "INSERT INTO users(login, password, registration_date, roles_id) values (?,?,?,?)";

		String sqlUsersDetails = "INSERT INTO userdetails(users_id, name, surname, email) values (?,?,?,?)";

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlUsers)) {

			if (checkLoginInDB(connection, user) || checkEmailInDB(connection, user)) {

				return rezRegistration;
			}
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			ps.setDate(3, registrationDate());
			ps.setInt(4, 2);

			ps.executeUpdate();

			try (PreparedStatement ps2 = connection.prepareStatement(sqlUsersDetails)) {

				ResultSet rs = ps.executeQuery("SELECT * FROM users");
				int users_id = 0;

				while (rs.next()) {
					users_id = rs.getInt(1);
				}

				ps2.setInt(1, users_id);
				ps2.setString(2, user.getFirstName());
				ps2.setString(3, user.getLastName());
				ps2.setString(4, user.getEmail());

				ps2.executeUpdate();
			}

			rezRegistration = true;

		} catch (ConnectionPoolException | SQLException e) {

			throw new DaoException();
		}

		return rezRegistration;

	}

	@Override
	public String role(String login, String password) throws DaoException {

		String role = "guest";

		String sqlRoles = "SELECT * FROM users JOIN roles ON users.roles_id = roles.id WHERE login=? AND password=?";

		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				PreparedStatement ps = connection.prepareStatement(sqlRoles)) {

			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				role = rs.getString("title");

				return role;
			}

		} catch (SQLException | ConnectionPoolException e) {

			throw new DaoException(e);
		}

		return role;
	}

	public boolean checkLoginInDB(Connection connection, NewUserInfo user) throws DaoException {

		boolean rezCheck = false;

		String sqlUsers = "SELECT * FROM users WHERE login=?";

		try (PreparedStatement ps = connection.prepareStatement(sqlUsers)) {

			ps.setString(1, user.getLogin());
			ResultSet rs = ps.executeQuery();

			if (rezCheck = rs.next()) {

				throw new DaoException("login", "This login is already in use!");
			}

		} catch (SQLException e) {
			throw new DaoException(e);
		}

		return rezCheck;
	}

	public boolean checkEmailInDB(Connection connection, NewUserInfo user) throws DaoException {

		boolean rezCheck = false;

		String sqlUserdetails = "SELECT * FROM userdetails WHERE email=?";

		try (PreparedStatement ps = connection.prepareStatement(sqlUserdetails)) {

			ps.setString(1, user.getEmail());
			ResultSet rs = ps.executeQuery();

			if (rezCheck = rs.next()) {

				throw new DaoException("email", "This email is already in use!");
			}

		} catch (SQLException e) {

			throw new DaoException(e);
		}

		return rezCheck;
	}

	public Date registrationDate() {

		GregorianCalendar registrationDate = new GregorianCalendar();

		return new java.sql.Date(registrationDate.getTimeInMillis());

	}

}
