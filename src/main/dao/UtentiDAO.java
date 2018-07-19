package main.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Utenti;

public class UtentiDAO 
{
	private final String QUERY_INSERT = "insert into utenti (username, password, ruolo) values (?,?,?)";
	private final String QUERY_SET_UTENTI = "UPDATE utenti SET user_name = ?, password =?, ruolo =? WHERE idutente=?";
    private final String QUERY_DELETE = "DELETE FROM utenti WHERE idutente=?";		 

    public boolean insertUtente(Utenti utenti) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, utenti.getUsername());
            preparedStatement.setString(2, utenti.getPassword());
            preparedStatement.setString(3, utenti.getRuolo());
                        return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean setUtente(Utenti utenti) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SET_UTENTI);
            preparedStatement.setString(1, utenti.getUsername());
            preparedStatement.setString(2, utenti.getPassword());
            preparedStatement.setString(3, utenti.getRuolo());
            preparedStatement.setInt(3, utenti.getIdutente());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean deleteUtente(Utenti utenti) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, utenti.getIdutente());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}


	
	

