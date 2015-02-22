package net.atos.devlapp.artikel;


enum ArtikelCategorie {

	ONDERDEEL('ON'),
	HALFPRODUCT('HP'),
	PRODUCT('PR'),
	DIVERSEN('DV')
	
	final String categorieCode;
	
	private ArtikelCategorie(String categorieCode){
		this.categorieCode = categorieCode;
	}
	
	static ArtikelCategorie byArtikelCategorie(String categorieCode) {
		values().find() {
			it.categorieCode == categorieCode
		}
	}
}
