package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	private final String QUERY_LOGIN = "select * from utenti where username = ? and password = ?";
	//private final String QUERY_LOGIN_ROLE = "select ruolo from utenti where username = ? and password = ?";

	public String login(String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet result=statement.executeQuery();
			String ruolo=null;
			if(result.next()) {
				ruolo= result.getString("ruolo");
			}
			return ruolo;
//			statement = connection.prepareStatement(QUERY_LOGIN_ROLE);
//			statement.setString(1, username);
//			statement.setString(2, password);
//			ResultSet resultSet = statement.executeQuery(QUERY_LOGIN_ROLE);
			
			
			
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

//	public String getRole() {
//
//		Connection connection = ConnectionSingleton.getInstance();
//
//		try {
//			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN_ROLE);
//			return statement.executeQuery().toString();
//		} catch (SQLException e) {
//			GestoreEccezioni.getInstance().gestisciEccezione(e);
//			return null;
//		}
//	}
}
