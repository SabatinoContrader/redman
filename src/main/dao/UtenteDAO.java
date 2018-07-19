package main.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;
import main.model.Utente;

public class UtenteDAO 
{
	private final String QUERY_INSERT = "insert into utenti (username, password, ruolo) values (?,?,?)";
	private final String QUERY_SET_UTENTI = "UPDATE utenti SET username = ?, password =?, ruolo =? WHERE username=?";
    private final String QUERY_DELETE = "DELETE FROM utenti WHERE username=?";		 
    private final String QUERY_SHOW = "Select * from utenti";
    
    public boolean insertUtente(Utente utente) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, utente.getUsername());
            preparedStatement.setString(2, utente.getPassword());
            preparedStatement.setString(3, utente.getRuolo());
            preparedStatement.execute();
                        return true;
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
           // preparedStatement.setInt(3, utente.getIdutente());
            preparedStatement.execute();
            return true;
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
        
    public List<Utente> getAllUtente () {
            List<Utente> UtentiList = new ArrayList<>();
            Connection connection = ConnectionSingleton.getInstance();
            try {
               Statement statement = connection.createStatement();
               ResultSet resultSet = statement.executeQuery(QUERY_SHOW);
               while (resultSet.next()) {
            	   int id_utente= Integer.parseInt(resultSet.getString("idutente"));
                   String username = resultSet.getString("username");
                   String password = resultSet.getString("password");
                   String ruolo = resultSet.getString("ruolo");
                   UtentiList.add(new Utente(id_utente,ruolo, username,password));
               }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            return UtentiList;
      
    }
}


	
	

