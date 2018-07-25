package main.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Task;

public class TaskDAO {
	
	private final String QUERY_SHOW = "Select * from tasks";
	 private final String QUERY_INSERT = "insert into tasks (idtask, idnodo, infotask, statotask) values (?,?,?,?)";

	    public TaskDAO() {

	    }
	    
	    public List<Task> getAllTasks () {
	        List<Task> ListaTask = new ArrayList<>();
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	           Statement statement = connection.createStatement();
	           ResultSet resultSet = statement.executeQuery(QUERY_SHOW);
	           while (resultSet.next()) {
	               int idtask = resultSet.getInt("idtask");
	               int idnodo = resultSet.getInt("idnodo");
	               String infotask = resultSet.getString("infotask");
	               String statotask = resultSet.getString("statotask");
	               ListaTask.add(new Task(idtask, idnodo, infotask, statotask));
	           }
	        }
	        catch (SQLException e) {
	        	e.printStackTrace();
	        }
	        return ListaTask;
	    }

	    public boolean insertTask(Task task) {
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
	            preparedStatement.setInt(1, task.getIdtask());
	            preparedStatement.setInt(1, task.getIdnodo());
	            preparedStatement.setString(2, task.getInfotask());
	            preparedStatement.setString(3, task.getStatotask());
	            preparedStatement.execute();
	            return true;
	            
	          
	        }
	        catch (SQLException e) {
	            GestoreEccezioni.getInstance().gestisciEccezione(e);
	            return false;
	        }

	    }
	    

}