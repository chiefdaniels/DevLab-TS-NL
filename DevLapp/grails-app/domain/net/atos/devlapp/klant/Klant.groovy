package net.atos.devlapp.klant

class Klant {
    Long id
    Long version
    
    Integer klantnummer
    
    String  voornaam
    String  achternaam

    String  bedrijfsnaam
	
    String  straatnaam
    Integer huisnummer
    String  huisnummertoevoeging
    String  postcode
    String  woonplaats
    
    
    String  telefoonnummer
    String  emailadres
    
    static constraints = {
		klantnummer blank:false
        bedrijfsnaam nullable: true

        voornaam blank:false, size: 1..25
        achternaam blank:false, size: 1..100    
        
        straatnaam blank:false, size:5..200
        huisnummer blank:false, size:1..10
        huisnummertoevoeging nullable: true
        postcode blank: false, matches: '\\d{4}[A-Za-z]{2}' 
        woonplaats size:1..200,blank:false
        
        telefoonnummer blank: false, matches: '\\d{2}\\-\\d{8}'
        emailadres blank: false, email: true

    }
    
}