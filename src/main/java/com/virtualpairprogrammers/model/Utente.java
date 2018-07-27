package main.model;

public class Utente {

	private int idutente;
	private String ruolo;
	private String username;
	private String password;

	public Utente(int idutente, String ruolo, String username, String password) {
		super();
		this.idutente = idutente;
		this.ruolo = ruolo;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utente [ruolo=" + ruolo + ", username=" + username + "]";
	}

	public Utente(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Utente(String ruolo, String username, String password) {
		this.ruolo = ruolo;
		this.username = username;
		this.password = password;
	}

	public int getIdutente() {
		return idutente;
	}

	public void setIdutente(int idutente) {
		this.idutente = idutente;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}