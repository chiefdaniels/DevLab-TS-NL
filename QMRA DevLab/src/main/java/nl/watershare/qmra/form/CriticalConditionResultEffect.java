package nl.watershare.qmra.form;

public class CriticalConditionResultEffect {

	private String effect;
	private String reference;
	
	public CriticalConditionResultEffect(String effect, String reference) {
		super();
		this.effect = effect;
		this.reference = reference;
	}

	public String getEffect() {
		return effect;
	}
	public String getReference() {
		return reference;
	}
}
