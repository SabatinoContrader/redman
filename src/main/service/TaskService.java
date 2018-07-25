package main.service;

import java.util.List;

import main.dao.TaskDAO;
import main.model.Task;

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
