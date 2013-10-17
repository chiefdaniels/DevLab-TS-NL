package nl.watershare.qmra.service;

import java.util.List;

import nl.watershare.qmra.dao.ResearchDataDAO;
import nl.watershare.qmra.entity.ResearchData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Service
public class ResearchDataService {

	@Autowired
	private ResearchDataDAO researchDataDAO;

	/**
	 * get researchData by researchId
	 * 
	 * @param researchId
	 * @return
	 */
	@Transactional
	public ResearchData getResearchData(Integer researchId) {
		ResearchData researchData = researchDataDAO.getResearchData(researchId);
		return researchData;
	}

	/**
	 * get list of researchData by searchCriteria
	 * 
	 * @param searchCriteria
	 * @return
	 */
	@Transactional
	public List<ResearchData> getResearchData(SelectionCriteria searchCriteria) {;
	List<ResearchData> researchDataList = researchDataDAO.getResearchData(searchCriteria);
	return researchDataList;
	}
	
	
	/**
	 * save researchData
	 * 
	 * @param researchData
	 * @return
	 */
	@Transactional
	public void saveResearchData(ResearchData researchData) {
		researchDataDAO.saveResearchData(researchData);
	}

	/**
	 * delete researchData
	 * 
	 * @param researchId
	 * @return
	 */
	@Transactional
	public void deleteResearchData(Integer researchId) {
		researchDataDAO.deleteResearchData(researchId);
	}
	
}
