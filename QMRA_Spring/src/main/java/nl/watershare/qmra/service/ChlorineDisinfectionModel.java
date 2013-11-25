package nl.watershare.qmra.service;

import nl.watershare.qmra.entity.ChlorineConstant;
import nl.watershare.qmra.form.types.ChlorinationType;
import nl.watershare.qmra.form.types.OrganismType;

public class ChlorineDisinfectionModel {
	
	private ChlorineConstantService chlorineConstantService;
	private OrganismType organismType;
	private ChlorinationType chlorinationType;
	private double hrt;
	private double residualC;
	private int cstr;

	public ChlorineDisinfectionModel(
			ChlorineConstantService chlorineConstantService,
			OrganismType organismType,
			ChlorinationType chlorinationType) {
		
		super();
		this.chlorineConstantService = chlorineConstantService;
		this.organismType = organismType;
		this.chlorinationType = chlorinationType;
	}

	public OrganismType getOrganismType() {
		return organismType;
	}
	public ChlorinationType getChlorinationType() {
		return chlorinationType;
	}
	public double getHrt() {
		return hrt;
	}
	public void setHrt(double hrt) {
		this.hrt = hrt;
	}
	public int getCstr() {
		return cstr;
	}
	public void setCstr(int cstr) {
		this.cstr = cstr;
	}
	public double getResidualC() {
		return residualC;
	}
	public void setResidualC(double residualC) {
		this.residualC = residualC;
	}
	
	public double getR() {
		return 8.314;
	}

	public double getE() {
		double e = 0;
		switch (this.organismType) {
			case BACTERIA: e = 0; break;
			case VIRUS: e = 49584.9243966592; break;
			case CRYPTOSPORIDIUM: e = 0; break;
			case GIARDIA: e = 46494.9094703705; break;
		}
		
		return e;
	}
	
	public double getA() {
		
		double a = 0;
		switch (this.organismType) {
			case BACTERIA: a = 0; break;
			case VIRUS: a = 6408351432.67659; break;
			case CRYPTOSPORIDIUM: a = 0; break;
			case GIARDIA: a = 21553962.1996717; break;
		}
		
		return a;
	}

	public double getKValue(double temperature) {
		
		double kValue = getA() * Math.exp(-getE() / (getR() * (temperature + 273.2)));
		
		return kValue;
	}
	
	public double getLogInactivation() {
		
		double logInact = 0;
		
		switch (this.chlorinationType) {
			case PLUGFLOW:
				switch (this.organismType) {
					case BACTERIA:
						logInact = 0;
						break;
					case VIRUS:
						logInact = -Math.log10(Math.exp(-(this.hrt * this.residualC) * getKValue(10)));
						break;
					case CRYPTOSPORIDIUM:
						logInact = 0;
						break;
					case GIARDIA:
						logInact = -Math.log10(Math.exp(-(this.hrt * this.residualC) * getKValue(10)));
						break;
				}
				break;
			case CSTR:
				switch (this.organismType) {
					case BACTERIA:
						logInact = 0;
						break;
					case VIRUS:
						logInact = -Math.log10(
							(1 / Math.pow(
								1 + (getKValue(10) * (this.hrt * this.residualC) / this.cstr),
								this.cstr)
							)
						);
						break;
					case CRYPTOSPORIDIUM:
						logInact = 0;
						break;
					case GIARDIA:
						logInact = -Math.log10(
							(1 / Math.pow(
								1 + (getKValue(10) * (this.hrt * this.residualC) / this.cstr),
								this.cstr)
							)
						);
						break;
				}
				break;
		}
		
		return logInact;
	}
	
	public double getContactTime(int logReduction, double temperature, double dose, double ph ) {

		double ctValue = getCTValue(logReduction, temperature, dose, ph );
		double contactTime = ctValue / dose;
		
		return contactTime;
	}
	
	public double getCTValue(int logReduction, double temperature, double dose, double ph ) {
		
		ChlorineConstant chlorineConstant = chlorineConstantService.getChlorineConstant(temperature, dose);
		double ctValue = 0;
		
		switch (this.chlorinationType) {
			case PLUGFLOW:
				switch (this.organismType) {
					case BACTERIA:
						ctValue = 0;
						break;
					case VIRUS:
						ctValue = -Math.log(Math.pow(10, -logReduction)) / getKValue(temperature);
						break;
					case CRYPTOSPORIDIUM:
						ctValue = 0;
						break;
					case GIARDIA:
						ctValue = (chlorineConstant.getA() * Math.exp((chlorineConstant.getB() * ph))) * (1 / (3.0 / logReduction));
						break;
				}
				break;
			case CSTR:
				switch (this.organismType) {
					case BACTERIA:
						ctValue = 0;
						break;
					case VIRUS:
						ctValue = (((this.cstr * (1.0 /  Math.pow(Math.pow(10, -logReduction), (1.0 / this.cstr)))) -
							this.cstr) / getKValue(temperature));
						break;
					case CRYPTOSPORIDIUM:
						ctValue = 0;
						break;
					case GIARDIA:
						
						double ct = (((this.cstr * (1.0 /  Math.pow(Math.pow(10, -logReduction), (1.0 / this.cstr)))) -
							this.cstr) / getKValue(temperature));

						double ctPF_ph7 = (chlorineConstant.getA() * Math.exp((chlorineConstant.getB() * 7))) * (1 / (3.0 / logReduction));
						double ctPF = (chlorineConstant.getA() * Math.exp((chlorineConstant.getB() * ph))) * (1 / (3.0 / logReduction));

						if (dose != 1) {
							ChlorineConstant chlorineConstant_dose1 = chlorineConstantService.getChlorineConstant(temperature, 1.0);
							double ctPF_ph7_dose1 = (chlorineConstant_dose1.getA() * Math.exp((chlorineConstant_dose1.getB() * 7))) * (1 / (3.0 / logReduction));
							
							ct = (ctPF_ph7_dose1 / ctPF_ph7) * ct;
						}
						ctValue = (ctPF / ctPF_ph7) * ct;
						
						break;
				}
				break;
		}
		
		return ctValue;
	}

}
