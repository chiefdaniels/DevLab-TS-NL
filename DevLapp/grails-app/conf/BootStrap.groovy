import net.atos.klant.Klant

class BootStrap {

    def init = { servletContext ->
		new Klant(klantnummer:1,voornaam:"Mark",achternaam:"Striekwold",bedrijfsnaam:"Atos",straatnaam:"Nieuwe Stationsstraat",huisnummer:20,postcode:"6811KS",woonplaats:"Arnhem",telefoonnummer:"06-30469471",emailadres:"mark.striekwold@atos.net").save()
		new Klant(klantnummer:2,voornaam:"Hans",achternaam:"Anders",bedrijfsnaam:"Atos",straatnaam:"Papendorpseweg",huisnummer:93,postcode:"3528BJ",woonplaats:"Utrecht",telefoonnummer:"06-12345678",emailadres:"hans.anders@atos.net").save()
	}
    def destroy = {
    }
}
