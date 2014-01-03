package dev.lab

class Boek {
	
	String titel
	Auteur auteur
	String ISBN
	
    static constraints = {
		ISBN(nullable:false,blank:false)
		titel(nullable:false,blank:false)
		auteur()
    }
	
	public String description() {
        return "$titel [auteur: ${auteur}, ISBN: $ISBN]"
    }
    
}
