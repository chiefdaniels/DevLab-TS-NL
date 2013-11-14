package nl.watershare.qmra.form;

import java.util.ArrayList;
import java.util.List;

public class CriticalConditionResultSubject {
	
	private String subject;
	private List<CriticalConditionResultEffect> effectList = new ArrayList<CriticalConditionResultEffect>();

	public CriticalConditionResultSubject(String subject, List<CriticalConditionResultEffect> effectList) {
		super();
		this.subject = subject;
		this.effectList = effectList;
	}
	
	public List<CriticalConditionResultEffect> getCriticalConditionResultEffectList() {
		return effectList;
	}
	public String getSubject() {
		return this.subject;
	}
	
}
