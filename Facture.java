package metier;

import java.time.LocalDate;

public class Facture {

	private int id; 		
	private LocalDate date ;	
	private Client  idclient ;	
	public Facture(int id,Client idclient, LocalDate date)
	{
		this.id=id;
		this.idclient = idclient;
		this.date = date;
	}

	public Facture() {}

	public Facture(int id) {
		this.id=id;
	}

	@Override
	public String toString() {
		return id+"";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Client getIdclient() {
		return idclient;
	}

	public void setIdclient(Client idclient) {
		this.idclient = idclient;
	}
	
}
