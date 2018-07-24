package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Task;

public class TaskDAO {

		 private final String QUERY_SHOW = "Select * from tasks";
		 private final String QUERY_INSERT = "insert into tasks (idtask, idnodo, infotask, statotask) values (?,?,?,?)";
		// private final String QUERY_INFO = "Select * from tasks";
		 
		    public TaskDAO() {

		    }
		    public List<Task> getAllTask () {
		        List<Task> tasks = new ArrayList<>();
		        Connection connection = ConnectionSingleton.getInstance();  //crea connessione con db
		        try {
		           Statement statement = connection.createStatement();
		           ResultSet resultSet = statement.executeQuery(QUERY_SHOW);
		           while (resultSet.next()) {
		               int idtask = resultSet.getInt("idtask");
		               int idnodo = resultSet.getInt("idnodo");
		               String infotask = resultSet.getString("infotask");
		               String statotask = resultSet.getString("statotask");
		               tasks.add(new Task(idtask, idnodo, infotask, statotask));
		           }
		        }
		        catch (SQLException e) {
		        	e.printStackTrace();
		        }
		        return tasks;
		    }

		    public boolean insertTasks(Task tasks) {
		        Connection connection = ConnectionSingleton.getInstance();
		        try {
		            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
		            preparedStatement.setInt(1, tasks.getIdtask());
		            preparedStatement.setInt(2, tasks.getIdnodo());
		            preparedStatement.setString(3, tasks.getInfotask());
		            preparedStatement.setString(4, tasks.getStatotask());
		            preparedStatement.execute();
		            return true;
		            
		          
		        }
		        catch (SQLException e) {
		            GestoreEccezioni.getInstance().gestisciEccezione(e);
		            return false;
		        }

		    }
	}

//}
