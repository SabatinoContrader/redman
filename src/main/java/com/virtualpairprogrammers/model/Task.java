package main.model;

public class Task {
	
	private int idtask;
	private int idnodo;
    private String infotask;
    private String statotask;

    public Task(int idtask, int idnodo, String infotask, String statotask) {
        this.idtask = idtask;
        this.idnodo = idnodo;
        this.infotask = infotask;
        this.statotask = statotask;

    }
    
    public Task() {}
	
	 public int getIdtask() {
	        return idtask;
	    }

	    public void setIdtask(int idtask) {
	        this.idtask = idtask;
	    }

	    public int getIdnodo() {
	        return idnodo;
	    }

	    public void setIdnodo(int idnodo) {
	        this.idnodo = idnodo;
	    }

	    public String getInfotask() {
	        return infotask;
	    }

	    public void setInfotask(String infotask) {
	        this.infotask = infotask;
	    }

	    public String getStatotask() {
	        return statotask;
	    }

	    public void setStatotask(String statotask) {
	        this.statotask = statotask;
	    }
	  
		@Override
		public String toString() {
			return "Task [idtask=" + idtask + ", idnodo=" + idnodo + ", infotask=" + infotask + ", statotask=" + statotask + "]";
		}
}


