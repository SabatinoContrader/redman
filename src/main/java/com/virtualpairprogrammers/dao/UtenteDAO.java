package main.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Utente;

public class UtenteDAO {
	private final String QUERY_INSERT = "insert into utenti (username, password, ruolo) values (?,?,?)";
	private final String QUERY_SET_UTENTI = "UPDATE utenti SET username = ?, password =? WHERE username=?";
	private final String QUERY_DELETE = "DELETE FROM utenti WHERE username=?";
	private final String QUERY_SHOW = "Select * from utenti";
	private final String QUERY_IDUTENTE = "Select idutente from utenti Where username = ?";
	private final String QUERY_RUOLOUTENTE = "Select ruolo from utenti Where username = ?";


	public boolean insertUtente(Utente utente) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, utente.getUsername());
			preparedStatement.setString(2, utente.getPassword());
			preparedStatement.setString(3, utente.getRuolo());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				return false;
			} else {
				GestoreEccezioni.getInstance().gestisciEccezione(e);
				return false;
			}
		}
	}

	public boolean setUtente(Utente utente, String VecchioUsername) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SET_UTENTI);
			preparedStatement.setString(1, utente.getUsername());
			preparedStatement.setString(2, utente.getPassword());
			preparedStatement.setString(3, VecchioUsername);
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				return false;
			} else {
				GestoreEccezioni.getInstance().gestisciEccezione(e);
				return false;
			}
		}

	}

	public boolean deleteUtente(String nomeUtente) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setString(1, nomeUtente);
			ResultSet rs = preparedStatement.executeQuery("select * from utenti");
			boolean status = false;
			while (rs.next()) {
				String username = rs.getString("username");
				if (username.equalsIgnoreCase(nomeUtente)) {
					preparedStatement.execute();
					status = true;
					break;
				}
			}
			return status;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public List<Utente> getAllUtente() {
		List<Utente> UtentiList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_SHOW);
			while (resultSet.next()) {
				int id_utente = Integer.parseInt(resultSet.getString("idutente"));
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String ruolo = resultSet.getString("ruolo");
				UtentiList.add(new Utente(id_utente, ruolo, username, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return UtentiList;

	}

	public int idutenteUtente(String username) {
		Connection connection = ConnectionSingleton.getInstance();
		int idutente = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_IDUTENTE);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			idutente = Integer.parseInt(resultSet.getString("idutente"));

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return idutente;
	}
	
	public String getRuoloUtente(String username) {
		Connection connection = ConnectionSingleton.getInstance();
		String Ruolo = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_RUOLOUTENTE);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			Ruolo = resultSet.getString("ruolo");

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return Ruolo;
	}
}
