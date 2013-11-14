package nl.watershare.qmra.form;

/**
 * @author Marco Kortooms - Atos
 *
 */
public enum LocationType {

	WEESP(
			0.15,
			0.0092,
			0.37,
			0.00065,
			0.000125,
			1.26
	),
	LEIDUIN(
			0.15,
			0.0092,
			0.39,
			0.00029,
			0.0000833333333333333,
			1.5			
	),
	SCHEVENINGEN(
			0.71,
			0.044,
			0.4,
			0.00053,
			0.0000833333333333333,
			1.24			
	),
	DEPUNT(
			0.052,
			0.0056,
			0.32,
			0.0005,
			0.0000555555555555556,
			1.61			
	);

	private double stickBateria;
	private double stickVirus;
	private double porosity;
	private double grainSize;
	private double rate;
	private double depth;
	
	private LocationType(double stickBateria, double stickVirus, double porosity, double grainSize, double rate, double depth) {
		this.stickBateria =stickBateria;
		this.stickVirus = stickVirus;
		this.porosity = porosity;
		this.grainSize = grainSize;
		this.rate = rate;
		this.depth = depth;
	}

	public double getStickBateria() {
		return stickBateria;
	}
	public double getStickVirus() {
		return stickVirus;
	}
	public double getPorosity() {
		return porosity;
	}
	public double getGrainSize() {
		return grainSize;
	}
	public double getRate() {
		return rate;
	}
	public double getDepth() {
		return depth;
	}
	
}