package nl.watershare.qmra.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Entity
@Table(name="QMRA_CHLORINE_CONSTANT")
public class ChlorineConstant implements Serializable {
	private static final long serialVersionUID = -7827289980509006493L;
	
	@Id
	@Column(name="TEMPERATURE")
	private Double temperature;
	@Id
	@Column(name="CHLORINECONCENTRATION")
	private Double chlorineConcentration;

	@Column(name="A")
	private Double a;
	@Column(name="B")
	private Double b;
	
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Double getChlorineConcentration() {
		return chlorineConcentration;
	}
	public void setChlorineConcentration(Double chlorineConcentration) {
		this.chlorineConcentration = chlorineConcentration;
	}
	public Double getA() {
		return a;
	}
	public void setA(Double a) {
		this.a = a;
	}
	public Double getB() {
		return b;
	}
	public void setB(Double b) {
		this.b = b;
	}
	
}
