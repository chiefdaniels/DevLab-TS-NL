package dev.lab

class Boek {
	
	String titel
	Auteur auteur
	String ISBN
	
    static constraints = {
    }
	
	public String description() {
        return "$titel [auteur: ${auteur}, ISBN: $ISBN]"
    }
    
}
