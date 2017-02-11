package feces.web.dto;

import feces.model.Namirnica;

public class CalcDTO {
	private Long idcalc;
	private Namirnica namirnica;
	private double kolicina;
	public Long getIdcalc() {
		return idcalc;
	}
	public void setIdcalc(Long idcalc) {
		this.idcalc = idcalc;
	}
	public double getKolicina() {
		return kolicina;
	}
	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}
	public Namirnica getNamirnica() {
		return namirnica;
	}
	public void setNamirnica(Namirnica namirnica) {
		this.namirnica = namirnica;
	}
}