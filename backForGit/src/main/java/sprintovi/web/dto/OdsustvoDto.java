package sprintovi.web.dto;

public class OdsustvoDto {
	private Long id;
	private String datumPocetka;
	private Long radnihDana;
	private Long radnikId;
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
	public Long getRadnikId() {
		return radnikId;
	}
	public void setRadnikId(Long radnikId) {
		this.radnikId = radnikId;
	}
	@Override
	public String toString() {
		return "OdsustvoDto [id=" + id + ", datumPocetka=" + datumPocetka + ", radnihDana=" + radnihDana + ", radnikId="
				+ radnikId + "]";
	}
	
	
}
