package sprintovi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Odsustvo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String datumPocetka;
	private Long radnihDana;
	@ManyToOne (fetch=FetchType.LAZY)
	private Radnik radnik;
	public Odsustvo() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public Long getRadnihDana() {
		return radnihDana;
	}
	public void setRadnihDana(Long radnihDana) {
		this.radnihDana = radnihDana;
	}
	public Radnik getRadnik() {
		return radnik;
	}
	public void setRadnik(Radnik radnik) {
		this.radnik = radnik;
	}
	
}
