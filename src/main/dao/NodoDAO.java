package main.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Nodo;

public class NodoDAO {
	
	 private final String QUERY_SHOW = "Select * from nodi";
	 private final String QUERY_INSERT = "insert into nodi (infonodo, statonodo, gruppi_idgruppo) values (?,?,?)";

	    public NodoDAO() {

	    }
	    public List<Nodo> getAllNodi () {
	        List<Nodo> nodi = new ArrayList<>();
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	           Statement statement = connection.createStatement();
	           ResultSet resultSet = statement.executeQuery(QUERY_SHOW);
	           while (resultSet.next()) {
	               int idnodo = resultSet.getInt("idnodo");
	               String infonodo = resultSet.getString("infonodo");
	               String statonodo = resultSet.getString("statonodo");
	               int gruppi_idgruppo = resultSet.getInt("gruppi_idgruppo");
	               nodi.add(new Nodo(idnodo, infonodo, statonodo, gruppi_idgruppo));
	           }
	        }
	        catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return nodi;
	    }

	    public boolean insertNodo(Nodo nodo) {
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
	            //preparedStatement.setInt(1, nodi.getIdnodo());
	            preparedStatement.setString(1, nodo.getInfonodo());
	            preparedStatement.setString(2, nodo.getStatonodo());
	            preparedStatement.setInt(3, nodo.getGruppi_idgruppo());
	            preparedStatement.execute();
	            return true;	          
	        }
	        catch (SQLException e) {
	        	if (e instanceof SQLIntegrityConstraintViolationException) {
	        		return false;
	        	} else {
	        		GestoreEccezioni.getInstance().gestisciEccezione(e);
	        		return false;
	        	}
	        }
	    }	    
}	    
