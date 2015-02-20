package net.atos.devLapp.artikel

import net.atos.devLapp.artikel.ArtikelCategorie;

class Artikel {
	
	Long id
	
	Integer artikelNummer
	
	String artikelNaam
	String artikelOmschrijving
	
	String categorieCode;

	static transients = ['artikelCategorie']

    static constraints = {
	
		artikelNummer blank:false

		artikelNaam blank:false, size: 1..25
		artikelOmschrijving blank:false, size: 1..500
		
		artikelCategorie blank:false, size:5..200
		
		categorieCode inList: ArtikelCategorie.values()*.categorieCode
    }
	
	static mapping = {
		
		categorieCode sqlType: 'char(2)'
	}
	
	ArtikelCategorie getArtikelCategorie() {
		categorieCode ? ArtikelCategorie.byArtikelCategorie(categorieCode): null
	}
	
	void getArtikelCategorie(ArtikelCategorie categogie) {
		categorieStr = categorie.categorieCode
	}
	
}
