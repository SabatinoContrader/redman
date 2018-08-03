package com.virtualpairprogrammers.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.virtualpairprogrammers.utils.ConnectionSingleton;
import com.virtualpairprogrammers.utils.GestoreEccezioni;
import com.virtualpairprogrammers.model.Task;

public class TaskDAO {
	
	private final String QUERY_SHOW = "Select *from tasks";
	 private final String QUERY_INSERT = "insert into tasks (idtask, idnodo, infotask, statotask) values (?,?,?,?)";
	 private final String QUERY_DELETE = "Delete from tasks where idtask=?";
	 private final String QUERY_UPDATESTATO ="UPDATE tasks SET statotask = ? Where idtask =?";
	 private final String QUERY_UPDATEIDNODO ="UPDATE tasks SET idnodo = ? Where idtask =?";
	 private final String QUERY_GETTASKSNM = "select * from tasks inner join nodi on tasks.idnodo=nodi.idnodo where idutente=?";
			

	 
	 
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
	    
	    public boolean deleteTask(int idTask) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
				preparedStatement.setInt(1, idTask);
				ResultSet rs = preparedStatement.executeQuery("select * from tasks");
				boolean status = false;
				while (rs.next()) {
					int idnodo = rs.getInt("idTask");
					if (idnodo == idTask) {
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

	    public boolean changeStatoTask(String statoTask,int idTask) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATESTATO);
				preparedStatement.setString(1, statoTask);
				preparedStatement.setInt(2, idTask);
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
	    
	    public boolean changeIdnodoTask(int idnodo,int idtask) {
			Connection connection = ConnectionSingleton.getInstance();
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATEIDNODO);
				preparedStatement.setInt(1, idnodo);
				preparedStatement.setInt(2, idtask);
				preparedStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public List<Task> getTasksNM(int idutente) {
			List<Task> ListaTask = new ArrayList<>();
	        Connection connection = ConnectionSingleton.getInstance();
	        try {
	        	PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GETTASKSNM);
				preparedStatement.setInt(1, idutente);			
				ResultSet resultSet = preparedStatement.executeQuery();
	        	
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

		public boolean setTask(int idtask, int idnodo) {
			
			return false;
		}

		
}