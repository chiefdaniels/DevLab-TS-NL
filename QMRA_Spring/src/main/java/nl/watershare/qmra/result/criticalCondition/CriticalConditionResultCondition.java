package nl.watershare.qmra.result.criticalCondition;

import java.util.ArrayList;
import java.util.List;

import nl.watershare.qmra.form.types.CriticalConditionType;

public class CriticalConditionResultCondition {

	private CriticalConditionType conditionType;
	private List<CriticalConditionResultSubject> subjectList = new ArrayList<CriticalConditionResultSubject>();

	public CriticalConditionResultCondition(CriticalConditionType conditionType,
			List<CriticalConditionResultSubject> subjectList) {
		super();
		this.conditionType = conditionType;
		this.subjectList = subjectList;
	}
	
	public List<CriticalConditionResultSubject> getCriticalConditionResultSubjectList() {
		return subjectList;
	}
	public CriticalConditionType getConditionType() {
		return this.conditionType;
	}
}
