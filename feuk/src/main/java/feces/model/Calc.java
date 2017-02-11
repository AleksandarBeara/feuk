package feces.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="calc")
public class Calc {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long idcalc;
	
	@OneToOne
	private Namirnica namirnica;
	
	@Column(name="kolicina")
	private double kolicina;

	public Calc() {
		super();
	}

	public Calc(Long idcalc, Namirnica namirnica, double kolicina) {
		super();
		this.idcalc = idcalc;
		this.namirnica = namirnica;
		this.kolicina = kolicina;
	}

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