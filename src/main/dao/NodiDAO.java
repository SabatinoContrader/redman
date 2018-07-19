package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NodiDAO {
	
	 private final String QUERY_ALL = "select * from nodi";
	 private final String QUERY_INSERT = "insert into nodi (idnodo, infonodo, statonodo) values (?,?,?)";

	    public NodiDAO() {

	    }
	    public List<Nodo> getAllNodi () {
	        List<Nodo> nodi = new ArrayList<>();
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	           Statement statement = connection.createStatement();
	           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
	           while (resultSet.next()) {
	               int idnodo = resultSet.getint("idnodo");
	               String infonodo = resultSet.getString("infonodo");
	               String statonodo = resultSet.getString("statonodo");
	               nodi.add(new Nodo(idnodo, infonodo, statonodo));
	           }
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return nodi;
	    }

	    public boolean insertNodi(Nodo nodi) {
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
	            preparedStatement.setString(1, nodi.getidnodo());
	            preparedStatement.setString(2, nodi.getinfonodo());
	            preparedStatement.setDouble(3, nodi.getstatonodo());
	            return preparedStatement.execute();
	            
	          
	        }
	        catch (SQLException e) {
	            GestoreEccezioni.getInstance().gestisciEccezione(e);
	            return false;
	        }

	    }
	}
