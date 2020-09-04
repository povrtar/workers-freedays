package godisnji.odmori.web.dto;

import java.util.Date;

public class OdsustvoDto {
	private Long id;
	private Date datumPocetka;
	private Date datumPovratka;
	private Long radnihDana;
	private Long radnikId;
	private String radnikName;
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
	public Long getRadnikId() {
		return radnikId;
	}
	public void setRadnikId(Long radnikId) {
		this.radnikId = radnikId;
	}
	
	public String getRadnikName() {
		return radnikName;
	}
	public void setRadnikName(String radnikName) {
		this.radnikName = radnikName;
	}
	@Override
	public String toString() {
		return "OdsustvoDto [id=" + id + ", datumPocetka=" + datumPocetka + ", radnihDana=" + radnihDana + ", radnikId="
				+ radnikId + "]";
	}
	
	
}
