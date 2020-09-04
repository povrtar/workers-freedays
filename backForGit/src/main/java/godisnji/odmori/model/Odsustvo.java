package godisnji.odmori.model;

import java.util.ArrayList;
import java.util.Date;
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
	
	private Date datumPocetka;
	private Date datumPovratka;
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
	
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	
	public Date getDatumPovratka() {
		return datumPovratka;
	}
	public void setDatumPovratka(Date datumPovratka) {
		this.datumPovratka = datumPovratka;
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
	@Override
	public String toString() {
		return "Odsustvo [id=" + id + ", datumPocetka=" + datumPocetka + ", datumPovratka=" + datumPovratka
				+ ", radnihDana=" + radnihDana + "]";
	}
	
}
