package nl.watershare.qmra.form;

import java.util.ArrayList;
import java.util.List;

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
