package nl.watershare.qmra.service;

import nl.watershare.qmra.dao.ChlorineConstantDAO;
import nl.watershare.qmra.entity.ChlorineConstant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Service
public class ChlorineConstantService {

	@Autowired
	private ChlorineConstantDAO chlorineConstantDAO;

	@Transactional
	public ChlorineConstant getChlorineConstant(Double temperature, Double chlorineConcentration) {
		
		ChlorineConstant chlorineConstant =
				chlorineConstantDAO.getChlorineConstant(temperature, chlorineConcentration);
		
		return chlorineConstant;
	}
		
	@Transactional
	public void saveChlorineConstant(ChlorineConstant chlorineConstant) {
		
		chlorineConstantDAO.saveChlorineConstant(chlorineConstant);
	}

	@Transactional
	public void deleteChlorineConstant(Double temperature, Double chlorineConcentration) {
		
		chlorineConstantDAO.deleteChlorineConstant(temperature, chlorineConcentration);
	}
	
}
