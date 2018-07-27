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
		    
		    /*public boolean setNodo (Nodo nodo) {
		        return this.nodoDAO.setNodi(nodo);
		    }
		    
		    public boolean deleteNodo (Nodo nodo) {
		        return this.nodoDAO.deleteNodi(nodo);
		    }*/
		    
		    public List<Task> getAllTasks () {
		        return this.taskDAO.getAllTasks();
		    }
		//    
		//    
//		    public List<Utente> getAllPaziente () {
//		        return this.utenteDAO.getAllPaziente();
//		    }
}
