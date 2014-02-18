
import dev.lab.tutorial.Auteur
import dev.lab.tutorial.Boek
import dev.lab.tutorial.Entry

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
		
		//Grafiek
		new Entry(dag:"1",aantal:"7").save()
		new Entry(dag:"2",aantal:"11").save()
		new Entry(dag:"3",aantal:"2").save()
		new Entry(dag:"4",aantal:"4").save()
		new Entry(dag:"5",aantal:"2").save()
		new Entry(dag:"6",aantal:"6").save()
		new Entry(dag:"7",aantal:"6").save()
		
		
		//QMRA stuff
		//new Chlorine_Constant().save()
		
    }
	
    def destroy = {
    }
}
