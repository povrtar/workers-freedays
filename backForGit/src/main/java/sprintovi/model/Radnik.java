package sprintovi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Radnik {

	@Id
	@GeneratedValue
	private Long id;
	
	private String jmbg;
	private String imeIPrezime;
	private String email;
	private Long godinaStaza;
	private Long slobodnihDana;

	
	@ManyToOne(fetch=FetchType.EAGER)
	private Odeljenje odeljenje;
	@OneToMany(mappedBy = "radnik", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List <Odsustvo> odsustva=new ArrayList<>();

	public Radnik() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getJmbg() {
		return jmbg;
	}


	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}


	public String getImeIPrezime() {
		return imeIPrezime;
	}


	public void setImeIPrezime(String imeIPrezime) {
		this.imeIPrezime = imeIPrezime;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getGodinaStaza() {
		return godinaStaza;
	}


	public void setGodinaStaza(Long godinaStaza) {
		this.godinaStaza = godinaStaza;
	}


	public Long getSlobodnihDana() {
		return slobodnihDana;
	}


	public void setSlobodnihDana(Long slobodnihDana) {
		this.slobodnihDana = slobodnihDana;
	}


	public Odeljenje getOdeljenje() {
		return odeljenje;
	}


	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
	}


	public List<Odsustvo> getOdsustva() {
		return odsustva;
	}


	public void setOdsustva(List<Odsustvo> odsustva) {
		this.odsustva = odsustva;
	}
	
	
}
