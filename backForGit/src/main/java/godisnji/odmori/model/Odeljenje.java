package godisnji.odmori.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Odeljenje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ime;
	private Long bonusSlobodihDana;
	@OneToMany(mappedBy = "odeljenje", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Radnik> radnici = new ArrayList<Radnik>();
	
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

	public List<Radnik> getRadnici() {
		return radnici;
	}

	public void setRadnici(List<Radnik> radnici) {
		this.radnici = radnici;
	}

	public Long getBonusSlobodihDana() {
		return bonusSlobodihDana;
	}

	public void setBonusSlobodihDana(Long bonusSlobodihDana) {
		this.bonusSlobodihDana = bonusSlobodihDana;
	}
	
	
}
