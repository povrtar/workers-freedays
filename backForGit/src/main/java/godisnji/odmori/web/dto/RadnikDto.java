package godisnji.odmori.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class RadnikDto {
	
	private Long id;
	
	private String jmbg;
	private String imeIPrezime;
	private String email;
	private Long godineStaza;
	private Long slobodnihDana;
	private Long odeljenjeId;
	private String odeljenjeName;
	public RadnikDto() {
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
	public Long getGodineStaza() {
		return godineStaza;
	}
	public void setGodineStaza(Long godineStaza) {
		this.godineStaza = godineStaza;
	}
	public Long getSlobodnihDana() {
		return slobodnihDana;
	}
	public void setSlobodnihDana(Long slobodnihDana) {
		this.slobodnihDana = slobodnihDana;
	}
	public Long getOdeljenjeId() {
		return odeljenjeId;
	}
	public void setOdeljenjeId(Long odeljenjeId) {
		this.odeljenjeId = odeljenjeId;
	}
	public String getOdeljenjeName() {
		return odeljenjeName;
	}
	public void setOdeljenjeName(String odeljenjeName) {
		this.odeljenjeName = odeljenjeName;
	}
	
	
}
