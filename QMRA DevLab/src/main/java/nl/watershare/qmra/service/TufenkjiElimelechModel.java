package nl.watershare.qmra.service;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TufenkjiElimelechModel {

	private Logger logger = LoggerFactory.getLogger(TufenkjiElimelechModel.class);

	private double HAMAKER_CONSTANT = 0.0000000000000000000062;
	private double happelModelParameter = 0; 
	private double collectorDiameter;
	private double fluidApproachVelocity;
	private double particleDensity;
	private double fluidDensity;
	private double temperature;
	private double porosity;
	private double particleSize;
	private DecimalFormat dc = null;
	
	public TufenkjiElimelechModel(double collectorDiameter,
			double fluidApproachVelocity, double particleDensity,
			double fluidDensity, double temperature, double porosity,
			double particleSize) {
		
		super();
		this.collectorDiameter = collectorDiameter;
		this.fluidApproachVelocity = fluidApproachVelocity;
		this.particleDensity = particleDensity;
		this.fluidDensity = fluidDensity;
		this.temperature = temperature;
		this.porosity = porosity;
		this.particleSize = particleSize;

		this.happelModelParameter = 2 * (1 - Math.pow(Math.pow((1 - porosity), (1.0 / 3)), 5)) /
				(2 - 3 * Math.pow((1 - porosity), (1.0 / 3)) +
				3 * Math.pow(Math.pow((1 - porosity), (1.0 / 3)), 5) -
				2 * Math.pow(Math.pow((1 - porosity), (1.0 / 3)), 6));
		
		dc = new DecimalFormat("#####0.0000000000000000000000000000");
	}

	public double calculate() {
		
		logger.info("*** New calculation ***");
		logger.info("collectorDiameter: " + dc.format(this.collectorDiameter));
		logger.info("fluidApproachVelocity: " + dc.format(this.fluidApproachVelocity));
		logger.info("particalDensity: " + dc.format(this.particleDensity));
		logger.info("fluidDensity: " + dc.format(this.fluidDensity));
		logger.info("temperature: " + dc.format(this.temperature));
		logger.debug("porosity: " + dc.format(this.porosity));
		logger.info("particleSize: " + dc.format(this.particleSize));
		logger.info("happelModelParameter: " + dc.format(this.happelModelParameter));
		
		double fluidViscosity = fluidDensity * 0.000497 / Math.pow((temperature + 42.5), 1.5);
		logger.info("fluidViscosity: " + dc.format(fluidViscosity));
		
		double nR = particleSize / (collectorDiameter * 1000);
		logger.info("nR: " + dc.format(nR));
		
		double nPE = ((6 * Math.PI) * fluidViscosity * (collectorDiameter * 0.001) * (particleSize * 0.0000005) 
				* fluidApproachVelocity) / ((temperature + 273) * 0.0000000000000000000000138);
		logger.info("nPE: " + dc.format(nPE));
		
		double nVdW = HAMAKER_CONSTANT / ((temperature + 273) * 0.0000000000000000000000138);
		logger.info("nVdW: " + dc.format(nVdW));
		
		double nA = nVdW / (nR * nPE);
		logger.info("nA: " + dc.format(nA));
		
		double nG = (2.0 / 9) * (particleDensity - fluidDensity) * 9.81 * Math.pow((particleSize * 0.0000005), 2) 
				/ (fluidViscosity * fluidApproachVelocity);
		logger.info("nG: " + dc.format(nG));
		
		double nD = 2.4 * (Math.pow(happelModelParameter, (1.0/3)) * Math.pow(nR, -0.081) * 
				Math.pow(nPE, -0.715) * Math.pow(nVdW, 0.052));
		logger.info("nD: " + dc.format(nD));
		
		double nI = 0.55 * happelModelParameter * Math.pow(nR, 1.675) * Math.pow(nA, 0.125);
		logger.info("nI: " + dc.format(nI));
		
		double ng = 0.22 * Math.pow(nR, -0.24) * Math.pow(nG, 1.11) * Math.pow(nVdW, 0.053);
		logger.info("ng: " + dc.format(ng));
		
		double n0 = nD + nI + ng;
		
		return n0;
	}
	
	public double getCollectorDiameter() {
		return collectorDiameter;
	}
	public void setCollectorDiameter(double collectorDiameter) {
		this.collectorDiameter = collectorDiameter;
	}
	public double getFluidApproachVelocity() {
		return fluidApproachVelocity;
	}
	public void setFluidApproachVelocity(double fluidApproachVelocity) {
		this.fluidApproachVelocity = fluidApproachVelocity;
	}
	public double getParticleDensity() {
		return particleDensity;
	}
	public void setParticleDensity(double particleDensity) {
		this.particleDensity = particleDensity;
	}
	public double getFluidDensity() {
		return fluidDensity;
	}
	public void setFluidDensity(double fluidDensity) {
		this.fluidDensity = fluidDensity;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getPorosity() {
		return porosity;
	}
	public void setPorosity(double porosity) {
		this.porosity = porosity;
	}
	public double getParticleSize() {
		return particleSize;
	}
	public void setParticleSize(double particleSize) {
		this.particleSize = particleSize;
	}

}
