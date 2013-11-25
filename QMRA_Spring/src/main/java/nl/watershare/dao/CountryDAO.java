package nl.watershare.dao;

import java.util.List;

import nl.watershare.common.Utils;
import nl.watershare.entity.Country;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Repository
public class CountryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Country getCountryByCode(String countryCode) {

		String queryStr =
				" from Country as c "+
				" where c.countryCode = :countryCode ";
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		query.setString("countryCode", countryCode);
		
		Country country = (Country)query.uniqueResult();

		return country;
	}

	public List<Country> getCountryList() {

		String queryStr =
				" from Country as c "+
				" where c.countryCode IS NOT NULL and " +
				" c.countryCode != 'xx' " +
				" order by c.countryCode";
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		
		List<Country> countryList = Utils.castList(Country.class, query.list());

		return countryList;
	}

	public List<Country> getCountryListByCountryName() {

		String queryStr =
				" from Country as c "+
				" where c.countryCode IS NOT NULL and " +
				" c.countryCode != 'xx' " +
				" order by c.countryName";
		
		Query query = sessionFactory.getCurrentSession().createQuery(queryStr);
		
		List<Country> countryList = Utils.castList(Country.class, query.list());

		return countryList;
	}

}
