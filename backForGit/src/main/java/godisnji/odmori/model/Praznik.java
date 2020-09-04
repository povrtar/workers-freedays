package godisnji.odmori.model;


import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Praznik {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ime;
	private Date datum;
	
	public Praznik() {
		super();
	}
	public Praznik(Long id, String ime, Date datum) {
		super();
		this.id = id;
		this.ime = ime;
		this.datum = datum;
	}
	public Praznik(String ime, Date datum) {
		
		this.ime = ime;
		this.datum = datum;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	
}
