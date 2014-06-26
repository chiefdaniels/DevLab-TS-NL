import dev.lab.tutorial.Auteur
import dev.lab.tutorial.Boek


class BootStrap {

    def init = { servletContext ->
		//Tutorial stuff
		new Auteur(voornaam:"Stefan",achternaam:"Livens").save()
		
		def a= new Auteur(voornaam:"Marco",achternaam:"Kortooms")
		a.save()
		
		def b= new Auteur(voornaam:"Maarten",achternaam:"Rozie")
		b.save()
		
		new Boek(titel:'Grails in Action',ISBN:'123',auteur:a).save()
		new Boek(titel:'Grails in Action v2',ISBN:'124',auteur:a).save()
		new Boek(titel:'Grails in Enterprise',ISBN:'129',auteur:b).save()

    }
    def destroy = {
    }
}
