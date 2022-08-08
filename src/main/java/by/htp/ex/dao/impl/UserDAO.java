package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.ex.bean.NewUserInfo;
import by.htp.ex.dao.DaoException;
import by.htp.ex.dao.IntUserDao;
import by.htp.ex.dao.conPool.ConnectionPool;
import by.htp.ex.dao.conPool.ConnectionPoolException;

public class UserDAO implements IntUserDao {
	

	@Override
	public boolean logination(String login, String password) throws DaoException {
		
	//	return true;
		return false;
	}


	@Override
	public boolean registration(NewUserInfo user) throws DaoException {
			
		String sqlUsers = "INSERT INTO users(login, password, name, surname, email) values (?,?,?,?,?)";
		
		try (Connection connection = ConnectionPool.getInstance().takeConnection(); 		
			PreparedStatement ps = connection.prepareStatement(sqlUsers)){
			
        	ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getEmail());
            
			ps.executeUpdate();
			
			
		} catch (ConnectionPoolException e) {
			throw new DaoException();
		}
		 catch (SQLException e) {
			 return false;
		}	

		return true;
		
	}

	@Override
	public String getRole(String login, String password) throws DaoException {
		// return "user";
		return "admin";
	}

}
