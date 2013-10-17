package nl.watershare.qmra.dao;

import java.util.List;

import nl.watershare.common.Utils;
import nl.watershare.qmra.entity.CriticalCondition;
import nl.watershare.qmra.service.SelectionCriteria;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Repository
public class CriticalConditionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public CriticalCondition getCriticalCondition(Integer conditionId) {
		
		String queryStr =
				" from CriticalCondition c " +
				" where conditionId = :conditionId";
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setInteger("conditionId", conditionId);
		CriticalCondition criticalCondition = (CriticalCondition)query.uniqueResult();

		return criticalCondition;
	}

	public List<CriticalCondition> getCriticalConditions(SelectionCriteria selectionCriteria) {;

		// *** Compose query string ***
		String queryStr = "from CriticalCondition c where " +
				" organismType =:organismType and" +
				" processType =:processType";

		switch (selectionCriteria.getProcessType()) {
			case FILTRATION: queryStr += " and filtrationType = :filtrationType"; break;
			case DISINFECTION: queryStr += " and disinfectionType = :disinfectionType"; break;
		}
				
//		switch (searchCriteria.getTargetType()) {
//			case TARGET:
//			case SURROGATE: queryStr += " and organismTarget = :organismTarget";
//		}
		
		queryStr = queryStr + " order by conditionType, subject, effect";
		// ****************************
		
		// *** Prepare query ***
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setString("organismType", selectionCriteria.getOrganismType().toString());
		query.setString("processType", selectionCriteria.getProcessType().toString());
		
		// *** Set query attributes ***
		switch (selectionCriteria.getProcessType()) {
			case FILTRATION: query.setString("filtrationType", selectionCriteria.getFiltrationType().toString()); break;
			case DISINFECTION: query.setString("disinfectionType", selectionCriteria.getDisinfectionType().toString()); break;
		}

//		switch (searchCriteria.getTargetType()) {
//			case TARGET:
//			case SURROGATE: query.setBoolean("organismTarget", searchCriteria.getTargetType().getBooleanValue());
//		}
		
		// ****************************
			
		List<CriticalCondition> criticalConditionList = Utils.castList(CriticalCondition.class, query.list());

		return criticalConditionList;
	}
		
	public void saveCriticalCondition(CriticalCondition criticalCondition) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(criticalCondition);		
	}

	public void deleteCriticalCondition(Integer conditionId) {
		CriticalCondition criticalCondition = getCriticalCondition(conditionId);
		if (criticalCondition != null) {
			sessionFactory.getCurrentSession().delete(criticalCondition);
		}
	}
}
