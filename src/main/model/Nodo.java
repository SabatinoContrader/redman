package main.model;

public class Nodo {

	private int idnodo;
    private String infonodo;
    private String statonodo;

    public Nodo(int idnodo, String infonodo, String statonodo) {
        this.idnodo = idnodo;
        this.infonodo = infonodo;
        this.statonodo = statonodo;
    }
	
	public Nodo() {}
	
	 public int getIdnodo() {
	        return idnodo;
	    }

	    public void setIdnodo(int idnodo) {
	        this.idnodo = idnodo;
	    }

	    public String getInfonodo() {
	        return infonodo;
	    }

	    public void setInfonodo(String infonodo) {
	        this.infonodo = infonodo;
	    }

	    public String getStatonodo() {
	        return statonodo;
	    }

	    public void setPrice(String statonodo) {
	        this.statonodo = statonodo;
	    }
	
}
