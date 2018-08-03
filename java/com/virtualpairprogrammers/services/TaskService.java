package com.virtualpairprogrammers.services;

import java.util.List;

import com.virtualpairprogrammers.dao.TaskDAO;
import com.virtualpairprogrammers.model.Task;

public class TaskService {
		
		private TaskDAO taskDAO;

		public TaskService() {
			this.taskDAO = new TaskDAO();
		}
		
		  public boolean insertTask (Task task) {
		        return this.taskDAO.insertTask(task);
		    }
		    
		    public boolean setTask (int idtask, int idnodo) {
		        return this.taskDAO.setTask(idtask,idnodo);
		    }
		    
		    public boolean deleteTask (Task task) {
		        return this.deleteTask(task);
		    }
		    
		    public boolean changeStatoTask (String statoTask,int idTask ) {
		        return this.changeStatoTask(statoTask,idTask);
		    }

		    
		    public List<Task> getAllTasks () {
		        return this.taskDAO.getAllTasks();
		    }
		    
		    public List<Task> getTasksNM (int idutente) {
		        return this.taskDAO.getTasksNM(idutente);
		    }
		//    
		//    
//		    public List<Utente> getAllPaziente () {
//		        return this.utenteDAO.getAllPaziente();
//		    }
}
