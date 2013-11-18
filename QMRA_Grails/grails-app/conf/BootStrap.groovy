import dev.lab.Auteur
import dev.lab.Boek

class BootStrap {

    def init = { servletContext ->
	
		new Auteur(voornaam:"Stefan",achternaam:"Livens").save()
		def a= new Auteur(voornaam:"Marco",achternaam:"Kortooms")
		a.save()
		new Boek(titel:'Grails in Action',ISBN:'123',auteur:a).save()
	
    }
    def destroy = {
    }
}
