package main.model;

public class Nodo {

	private int idnodo;
	private String infonodo;
	private String statonodo;
	private int gruppi_idgruppo;

	public Nodo() {

	}

	public Nodo(int idnodo, String infonodo, String statonodo, int gruppi_idgruppo) {
		this.idnodo = idnodo;
		this.infonodo = infonodo;
		this.statonodo = statonodo;
		this.gruppi_idgruppo = gruppi_idgruppo;
	}

	public Nodo(String infonodo, String statonodo, int gruppi_idgruppo) {
		this.infonodo = infonodo;
		this.statonodo = statonodo;
		this.gruppi_idgruppo = gruppi_idgruppo;
	}
	

	public Nodo(String infonodo, String statonodo) {
		this.infonodo = infonodo;
		this.statonodo = statonodo;
	}

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

	public void setStatoNodo(String statonodo) {
		this.statonodo = statonodo;
	}

	public int getGruppi_idgruppo() {
		return gruppi_idgruppo;
	}

	public void setGruppi_idgruppo(int gruppi_idgruppo) {
		this.gruppi_idgruppo = gruppi_idgruppo;
	}

	@Override
	public String toString() {
		return "Nodo [idnodo=" + idnodo + ", infonodo=" + infonodo + ", statonodo=" + statonodo + ", gruppi_idgruppo="
				+ gruppi_idgruppo + "]";
	}

}
