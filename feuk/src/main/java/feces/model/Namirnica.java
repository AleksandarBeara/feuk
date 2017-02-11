package feces.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_namirnica")
public class Namirnica {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="kalorije")
	private double kalorije;
	
	@Column(name="ugljenihidrati")
	private double ugljeniHidrati;
	
	@Column(name="masti")
	private double masti;
	
	@Column(name="proteini")
	private double proteini;
	
	@Column(name="secer")
	private double secer;
	
	public Namirnica() {
		super();
	}
	
	public Namirnica(String name, double kalorije, double ugljeniHidrati, double masti, double proteini, double secer) {
		super();
		this.name = name;
		this.kalorije = kalorije;
		this.ugljeniHidrati = ugljeniHidrati;
		this.masti = masti;
		this.proteini = proteini;
		this.secer = secer;
	}
	
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