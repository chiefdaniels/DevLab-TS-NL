package dev.lab.tutorial

import dev.lab.tutorial.Auteur

class Boek {
	
	String titel
	Auteur auteur
	String ISBN
	int pages
	
    static constraints = {
		ISBN(nullable:false,blank:false)
		titel(nullable:false,blank:false)
		auteur()
		pages()
    }
	
	public String toString() {
        return "$titel (${auteur})"
    }
	
	public String description() {
		return "$titel [auteur: ${auteur}, ISBN: $ISBN]"
	}
    
}
