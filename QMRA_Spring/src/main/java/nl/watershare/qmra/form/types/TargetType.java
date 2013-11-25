package nl.watershare.qmra.form.types;

/**
 * @author Marco Kortooms - Atos
 *
 */
public enum TargetType {

	TARGET("true"), SURROGATE("false"), BOTH("");

	private Boolean booleanValue;
	
	private TargetType(String booleanValue) {
		this.booleanValue = new Boolean(booleanValue);
	}
		
	public Boolean getBooleanValue() {
		return booleanValue;
	}
	
}
