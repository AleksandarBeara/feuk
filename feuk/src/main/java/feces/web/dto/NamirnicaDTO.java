package feces.web.dto;

public class NamirnicaDTO {
	private Long id;
	private String name;
	private double kalorije;
	private double ugljeniHidrati;
	private double masti;
	private double proteini;
	private double secer;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getKalorije() {
		return kalorije;
	}
	public void setKalorije(double kalorije) {
		this.kalorije = kalorije;
	}
	public double getUgljeniHidrati() {
		return ugljeniHidrati;
	}
	public void setUgljeniHidrati(double ugljeniHidrati) {
		this.ugljeniHidrati = ugljeniHidrati;
	}
	public double getMasti() {
		return masti;
	}
	public void setMasti(double masti) {
		this.masti = masti;
	}
	public double getProteini() {
		return proteini;
	}
	public void setProteini(double proteini) {
		this.proteini = proteini;
	}
	public double getSecer() {
		return secer;
	}
	public void setSecer(double secer) {
		this.secer = secer;
	}
}