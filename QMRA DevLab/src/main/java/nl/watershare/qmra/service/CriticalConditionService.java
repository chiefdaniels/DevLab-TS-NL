package nl.watershare.qmra.service;

import java.util.List;

import nl.watershare.qmra.dao.CriticalConditionDAO;
import nl.watershare.qmra.entity.CriticalCondition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Service
public class CriticalConditionService {

	@Autowired
	private CriticalConditionDAO criticalConditionDAO;

	/**
	 * get criticalCondition by conditionId
	 * 
	 * @param conditionId
	 * @return
	 */
	@Transactional
	public CriticalCondition getCriticalCondition(Integer conditionId) {
		CriticalCondition criticalCondition = criticalConditionDAO.getCriticalCondition(conditionId);
		return criticalCondition;
	}

	/**
	 * get list of criticalConditions by searchCriteria
	 * 
	 * @param searchCriteria
	 * @return
	 */
	@Transactional
	public List<CriticalCondition> getCriticalConditions(SelectionCriteria searchCriteria) {;
	List<CriticalCondition> criticalConditionList = criticalConditionDAO.getCriticalConditions(searchCriteria);
	return criticalConditionList;
	}
	
	
	/**
	 * save criticalCondition
	 * 
	 * @param criticalCondition
	 * @return
	 */
	@Transactional
	public void saveCriticalCondition(CriticalCondition criticalCondition) {
		criticalConditionDAO.saveCriticalCondition(criticalCondition);
	}

	/**
	 * delete criticalCondition
	 * 
	 * @param conditionId
	 * @return
	 */
	@Transactional
	public void deleteCriticalCondition(Integer conditionId) {
		criticalConditionDAO.deleteCriticalCondition(conditionId);
	}
	
}
