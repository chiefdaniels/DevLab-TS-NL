package net.atos.devlapp.bestelling

import net.atos.devlapp.verkoper.Verkoper
import net.atos.klant.Klant

class Bestelling {

	Integer bestelnummer
	Verkoper verkoper
	Klant klant
	
    static constraints = {
		bestelnummer blank:false
		verkoper blank:false
		klant blank:false
    }
}
