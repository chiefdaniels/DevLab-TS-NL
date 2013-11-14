package nl.watershare.qmra.service;

import nl.watershare.qmra.form.LocationType;
import nl.watershare.qmra.form.OrganismType;

public class SlowSandFiltrationModel {
	
	private static final double SCHIJVENF0 = 0.00021;
	private static final double SCHIJVENF1 = 0.099;

//	private DecimalFormat dc = new DecimalFormat("#####0.0000000000000000000000000000");

	private LocationType locationType;
	private OrganismType organismType;
	private int schmutzdeckeAge;
	private double temperature;
	
	public SlowSandFiltrationModel(
			OrganismType organismType,
			LocationType locationType,
			int schmutzdeckeAge,
			double temperature) {
		
		super();
		this.locationType = locationType;
		this.organismType = organismType;
		this.schmutzdeckeAge = schmutzdeckeAge;
		this.temperature = temperature;
	}
	
	public OrganismType getOrganismType() {
		return organismType;
	}
	public int getSchmutzdeckeAge() {
		return schmutzdeckeAge;
	}
	public LocationType getLocationType() {
		return locationType;
	}
	public double getTemperature() {
		return temperature;
	}
	public double getTufenkjiEta() {
		
		double particleSize = 0;
		switch (this.organismType) {
			case BACTERIA: particleSize = 1.5; break;
			case VIRUS: particleSize = 0.02; break;
			case CRYPTOSPORIDIUM: particleSize = 10; break;
			case GIARDIA: particleSize = 15; break;
		}
		
		TufenkjiElimelechModel te = new TufenkjiElimelechModel(
				(locationType.getGrainSize() * 1000), // collectorDiameter
				locationType.getRate(), // fluidApproachVelocity
				1085, //particleDensity
				999.703, // fluidDensity
				this.temperature, // temprature
				locationType.getPorosity(), // porosity
				particleSize); // particleSize
		
		double tufenkjiEta = te.calculate();

		return tufenkjiEta;
	}
	public double getModelSchijvenHechting() {
		switch (this.organismType) {
			case BACTERIA: return locationType.getStickBateria();
			case VIRUS: return locationType.getStickVirus();
			default: return 0;
		}
	}
	public double getModelSchijvenF0() {
		return SCHIJVENF0;
	}
	public double getModelSchijvenF1() {
		return SCHIJVENF1;
	}
	public double getRemovalCalculatedLNC() {
				
		double calculatedRemoval = (3.0 / 2) *
				(( 1.0 - locationType.getPorosity()) / locationType.getGrainSize()) * 
				((getModelSchijvenHechting() * getTufenkjiEta() * locationType.getDepth()) + 
				(SCHIJVENF0 * this.temperature * 
				(1 - Math.exp(-getModelSchijvenHechting() * SCHIJVENF1 * this.schmutzdeckeAge))));

		return calculatedRemoval;
	}
	public double getRemovalCalculatedDEC() {
		
		return getRemovalCalculatedLNC() / 2.3;
	}
	
}
