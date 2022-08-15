package by.htp.ex.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
				PreparedStatement ps = connection.prepareStatement(sqlUsers)){
			
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
				
			if (rs.next()) {
				
				System.out.println(rs.getInt(1) + " " + rs.getString(2) +
						" " + rs.getString(3)); 
				rezLogination = true;
			}

		}catch (ConnectionPoolException e) {
			throw new DaoException();
		}
		 catch (SQLException e) {
			 throw new DaoException();
		}
		return rezLogination;
	}


	@Override
	public boolean registration(NewUserInfo user) throws DaoException {
				
		boolean rezRegistration = false;
			
	//	String sqlUsers = "INSERT INTO users(login, password, registration_date, roles_id) values (?,?,?,?)";
		
	//	String sqlUsersDetails = "INSERT INTO userdetails(name, surname, email) values (?,?,?)";
		
				
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
				Statement st = connection.createStatement()	){
			 		
			
			if(checkLoginInDB(connection,user) || checkEmailInDB(connection,user)) {
				
				return rezRegistration;
			}
			
			String login = user.getLogin();
			String password = user.getPassword();
			String registration_date = "today";
			int roles_id = 2;
			String name = user.getLastName();
			String surname = user.getLastName();
			String email = user.getEmail();
			
			st.addBatch("INSERT INTO users(login, password, registration_date, roles_id) values(login,password,registration_date, roles_id)");
			
			st.addBatch("INSERT INTO userdetails(name, surname, email) values (name,surname,email)");

			int[] update = st.executeBatch();
			
			rezRegistration = true;
			
		} 
		catch (ConnectionPoolException e) {
			System.out.println("ConnectionPoolException");
			throw new DaoException();
		}
		 catch (SQLException e) {
			 System.out.println("SQLException");
			 System.out.println(e);
			 throw new DaoException();
		}
		return rezRegistration;

		
	}

	@Override
	public String getRole(String login, String password) throws DaoException {
		// return "user";
		return "admin";
	}
	
	public boolean checkLoginInDB (Connection connection, NewUserInfo user) throws DaoException {
		boolean rezCheck = false;
		System.out.println("checkLoginInDB");
		String sql = "SELECT * FROM users WHERE login=?";
		
		try {			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ResultSet rs = ps.executeQuery();
						
			if (rezCheck = rs.next()) {
								
				throw new DaoException("login", "This login is already in use!");
			}
			
		} catch (SQLException e) {
			throw new DaoException(e);
		}		
		System.out.println("rezCheck = " + rezCheck);
		return rezCheck;
	}
	
	public boolean checkEmailInDB (Connection connection,NewUserInfo user) throws DaoException{
		
		boolean rezCheck = false;
		
		System.out.println("checkEmailInDB");
		
		String sql = "SELECT * FROM userdetails WHERE email=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ResultSet rs = ps.executeQuery();
			
			if (rezCheck = rs.next()) {
				
				throw new DaoException("email", "This email is already in use!");
			}
			
		} catch (SQLException e) {
			System.out.println("SQLException" );
			throw new DaoException(e);
		}		
		System.out.println("rezCheck = " + rezCheck);
		return rezCheck;
	}
		

}
