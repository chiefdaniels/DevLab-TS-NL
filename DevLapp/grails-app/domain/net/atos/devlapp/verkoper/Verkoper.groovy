package net.atos.devlapp.verkoper

class Verkoper {

	Integer verkoperID
	String voornaam
	String achternaam
	Date geboortedatum
	Double salaris
	String emailadres
	String telefoonnummer
	
	static constraints = {
		verkoperID blank:false

		voornaam blank:false, size: 1..25
		achternaam blank:false, size: 1..100
		
		telefoonnummer blank: false, matches: '\\d{2}\\-\\d{8}'
		emailadres blank: false, email: true

	}
}
