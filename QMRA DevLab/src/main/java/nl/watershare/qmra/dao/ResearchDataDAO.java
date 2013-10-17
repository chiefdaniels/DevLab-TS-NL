package nl.watershare.qmra.dao;

import java.util.List;

import nl.watershare.common.Utils;
import nl.watershare.qmra.entity.ResearchData;
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
public class ResearchDataDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ResearchData getResearchData(Integer researchId) {
		
		String queryStr =
				" from ResearchData r " +
				" where researchId = :researchId";
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setInteger("researchId", researchId);
		ResearchData researchData = (ResearchData)query.uniqueResult();

		return researchData;
	}

	public List<ResearchData> getResearchData(SelectionCriteria selectionCriteria) {;

		// *** Compose query string ***
		String queryStr = "from ResearchData r where " +
				" organismType = :organismType and" +
				" processType = :processType";

		switch (selectionCriteria.getProcessType()) {
			case FILTRATION:
				queryStr += " and filtrationType = :filtrationType";
				break;
				
			case DISINFECTION:
				queryStr += " and disinfectionType = :disinfectionType";
				switch (selectionCriteria.getDisinfectionType()) {
					case UV:
						switch (selectionCriteria.getUvType()) {
							case LP:
							case MP: queryStr += " and virus_uvType = :virus_uvType"; break;
						}
						break;
				}
				break;
		}
		
		switch (selectionCriteria.getTargetType()) {
			case TARGET:
			case SURROGATE: queryStr += " and organismTarget = :organismTarget";
		}
		// *****************************
		
		// *** Prepare query ***
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setString("organismType", selectionCriteria.getOrganismType().toString());
		query.setString("processType", selectionCriteria.getProcessType().toString());
		
		// *** Set query attributes ***
		switch (selectionCriteria.getProcessType()) {
			case FILTRATION:
				query.setString("filtrationType", selectionCriteria.getFiltrationType().toString());
				break;
				
			case DISINFECTION:
				query.setString("disinfectionType", selectionCriteria.getDisinfectionType().toString());
				switch (selectionCriteria.getDisinfectionType()) {
					case UV:
						switch (selectionCriteria.getUvType()) {
							case LP:
							case MP: query.setString("virus_uvType", selectionCriteria.getUvType().toString()); break;
						}
						break;
				}
				break;
		}
		
		switch (selectionCriteria.getTargetType()) {
			case TARGET:
			case SURROGATE: query.setBoolean("organismTarget", selectionCriteria.getTargetType().getBooleanValue());
		}
		// *****************************
	
		List<ResearchData> researchDataList = Utils.castList(ResearchData.class, query.list());

		return researchDataList;
	}
		
	public void saveResearchData(ResearchData researchData) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(researchData);		
	}

	public void deleteResearchData(Integer researchId) {
		ResearchData researchData = getResearchData(researchId);
		if (researchData != null) {
			sessionFactory.getCurrentSession().delete(researchData);
		}
	}
}
