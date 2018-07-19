package main.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Utente;

public class UtenteDAO 
{
	private final String QUERY_INSERT = "insert into utenti (username, password, ruolo) values (?,?,?)";
	private final String QUERY_SET_UTENTI = "UPDATE utenti SET user_name = ?, password =?, ruolo =? WHERE idutente=?";
    private final String QUERY_DELETE = "DELETE FROM utenti WHERE idutente=?";		 
    private final String QUERY_SHOW = "Select * from utenti";
    
    public boolean insertUtente(Utente utente) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, utente.getUsername());
            preparedStatement.setString(2, utente.getPassword());
            preparedStatement.setString(3, utente.getRuolo());
                        return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean setUtente(Utente utente) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_SET_UTENTI);
            preparedStatement.setString(1, utente.getUsername());
            preparedStatement.setString(2, utente.getPassword());
            preparedStatement.setString(3, utente.getRuolo());
            preparedStatement.setInt(3, utente.getIdutente());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
    
    public boolean deleteUtente(Utente utente) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
            preparedStatement.setInt(1, utente.getIdutente());
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
        
      
    }
}


	
	

