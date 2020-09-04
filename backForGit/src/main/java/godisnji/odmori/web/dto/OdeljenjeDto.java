package godisnji.odmori.web.dto;

public class OdeljenjeDto {
	
	private Long id;
	private String ime;
	private Long bonusSlobodnihDana;
	public OdeljenjeDto() {
		super();
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
	public Long getBonusSlobodnihDana() {
		return bonusSlobodnihDana;
	}
	public void setBonusSlobodnihDana(Long bonusSlobodnihDana) {
		this.bonusSlobodnihDana = bonusSlobodnihDana;
	}
	
}
