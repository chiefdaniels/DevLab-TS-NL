package nl.watershare.qmra.dao;

import nl.watershare.qmra.entity.ChlorineConstant;

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
public class ChlorineConstantDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public ChlorineConstant getChlorineConstant(Double temperature, Double chlorineConcentration) {
		
		String queryStr =
				" from ChlorineConstant c " +
				" where temperature = :temperature and " +
				" chlorineConcentration = :chlorineConcentration";
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setDouble("temperature", temperature);
		query.setDouble("chlorineConcentration", chlorineConcentration);
		
		ChlorineConstant chlorineConstant = (ChlorineConstant)query.uniqueResult();

		return chlorineConstant;
	}
		
	public void saveChlorineConstant(ChlorineConstant chlorineConstant) {
		
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(chlorineConstant);		
	}

	public void deleteChlorineConstant(Double temperature, Double chlorineConcentration) {
		ChlorineConstant chlorineConstant = getChlorineConstant(temperature, chlorineConcentration);
		if (chlorineConstant != null) {
			sessionFactory.getCurrentSession().delete(chlorineConstant);
		}
	}
}
