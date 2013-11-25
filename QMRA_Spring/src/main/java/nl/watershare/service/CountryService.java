package nl.watershare.service;

import java.util.List;

import nl.watershare.dao.CountryDAO;
import nl.watershare.entity.Country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Marco Kortooms - Atos
 *
 */
@Service
public class CountryService {

	@Autowired
	private CountryDAO countryDAO;
		
	@Transactional
	public Country getCountryByCode(String code) {
		return countryDAO.getCountryByCode(code);
	}

	@Transactional
	public List<Country> getCountryList() {
		return countryDAO.getCountryList();
	}

	@Transactional
	public List<Country> getCountryListByCountryName() {
		return countryDAO.getCountryListByCountryName();
	}

}