import net.atos.devLapp.artikel.Artikel
import net.atos.klant.Klant

class BootStrap {

    def init = { servletContext ->
		new Klant(
			klantnummer:1,
			voornaam:"Mark",
			achternaam:"Striekwold",
			bedrijfsnaam:"Atos",
			straatnaam:"Nieuwe Stationsstraat",
			huisnummer:20,
			postcode:"6811KS"
			,woonplaats:"Arnhem",
			telefoonnummer:"06-30469471",
			emailadres:"mark.striekwold@atos.net").save()
			
		new Klant(
			klantnummer:2,
			voornaam:"Hans",
			achternaam:"Anders",
			bedrijfsnaam:"Atos",
			straatnaam:"Papendorpseweg",
			huisnummer:93,
			postcode:"3528BJ",
			woonplaats:"Utrecht",
			telefoonnummer:"06-12345678",
			emailadres:"hans.anders@atos.net").save()

			
		new Artikel(
			artikelNummer: 1,
			artikelNaam: "Schroef M6x12",
			artikelOmschrijving: "Dit is de omschrijving van een schroef M6x12",
			categorieCode: "ON"
			).save()
			
		new Artikel(
			artikelNummer: 2,
			artikelNaam: "Elektromotor",
			artikelOmschrijving: "Elektromotor voor inbouw in een machine M",
			categorieCode: "HP"
			).save()

		new Artikel(
			artikelNummer: 3,
			artikelNaam: "Papier A5 500 vel",
			artikelOmschrijving: "Pak papier 500 vel A4 voor gebruik in een kopieerapparaat",
			categorieCode: "DV"
			).save()

		new Artikel(
			artikelNummer: 4,
			artikelNaam: "Aluminium profiel",
			artikelOmschrijving: "aluminium profiel voor gebruik in Machine M",
			categorieCode: "ON"
			).save()			
	
		new Artikel(
			artikelNummer: 5,
			artikelNaam: "Machine M",
			artikelOmschrijving: "Machine voor teleportering naar Mars",
			categorieCode: "PR"
			).save()
			
	}
	
    def destroy = {
    }
}
