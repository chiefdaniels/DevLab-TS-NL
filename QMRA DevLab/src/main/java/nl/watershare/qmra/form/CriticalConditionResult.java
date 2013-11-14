package nl.watershare.qmra.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.watershare.qmra.entity.CriticalCondition;
import nl.watershare.qmra.service.SelectionCriteria;

public class CriticalConditionResult {

	private SelectionCriteria searchCriteria;
	private List<CriticalCondition> criticalConditionList;

	public CriticalConditionResult(SelectionCriteria searchCriteria,
			List<CriticalCondition> criticalConditionList) {
		super();
		this.searchCriteria = searchCriteria;
		this.criticalConditionList = criticalConditionList;
	}
	
	public SelectionCriteria getSearchCriteria() {
		return searchCriteria;
	}
	public List<CriticalCondition> getCriticalConditionList() {
		return criticalConditionList;
	}

	public List<CriticalConditionResultCondition> getConditionTypeList() {
		
		List<CriticalConditionResultEffect> effectList = null;
		HashMap<String, List<CriticalConditionResultEffect>> subjectMap = null;
		HashMap<CriticalConditionType, List<CriticalConditionResultSubject>> conditionMap =
			new HashMap<CriticalConditionType, List<CriticalConditionResultSubject>>();
		
		for (CriticalCondition criticalCondition : criticalConditionList) {

			if (!conditionMap.containsKey(criticalCondition.getConditionType())) {
				subjectMap = new HashMap<String, List<CriticalConditionResultEffect>>();
			}
			if (!subjectMap.containsKey(criticalCondition.getSubject())) {
				effectList = new ArrayList<CriticalConditionResultEffect>();
			}

			effectList.add(
				new CriticalConditionResultEffect(
					criticalCondition.getEffect(),
					criticalCondition.getReferences()
				)
			);
			subjectMap.put(
				criticalCondition.getSubject(),
				effectList
			);
			
			conditionMap.put(
				criticalCondition.getConditionType(),
				getCrititcalConditionResultSubjectList(subjectMap)
			);
		}
		
		return getCrititcalConditionResultConditionList(conditionMap);
	}
	
	private List<CriticalConditionResultSubject> getCrititcalConditionResultSubjectList(
			HashMap<String, List<CriticalConditionResultEffect>> subjectMap) {
		
		List<CriticalConditionResultSubject> subjectList = new ArrayList<CriticalConditionResultSubject>();
		
		for (Map.Entry<String, List<CriticalConditionResultEffect>> entry : subjectMap.entrySet()) {
	        subjectList.add(
		       	new CriticalConditionResultSubject(
		       		entry.getKey(),
		       		entry.getValue()
		       	)
	        );
		}
		return subjectList;
	}
	
	private List<CriticalConditionResultCondition> getCrititcalConditionResultConditionList(
			HashMap<CriticalConditionType, List<CriticalConditionResultSubject>> conditionMap) {
		
		List<CriticalConditionResultCondition> conditionList = new ArrayList<CriticalConditionResultCondition>();
		
		for (Map.Entry<CriticalConditionType, List<CriticalConditionResultSubject>> entry : conditionMap.entrySet()) {
			conditionList.add(
		       	new CriticalConditionResultCondition(
		       		entry.getKey(),
		       		entry.getValue()
		       	)
	        );
		}
		return conditionList;
	}
	
}
