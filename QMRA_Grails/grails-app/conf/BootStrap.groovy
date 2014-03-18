
import dev.lab.tutorial.Auteur
import dev.lab.tutorial.Boek
import dev.lab.tutorial.Entry
import dev.lab.qmra.Chlorine_Constant
import dev.lab.qmra.ResearchData

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
		new Chlorine_Constant(chlorineConcentration:"5.0",temperature:"18,5").save()
		new Chlorine_Constant(chlorineConcentration:"25.0",temperature:"28,5").save()
		
		// ResearchDAta
		new ResearchData(
			researchId:60,
			year:1991,
			organismType:'CRYPTOSPORIDIUM',
			organismTarget:0,
			processType:'CONVENTIONAL',
			publicationType:'REPORT',
			publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',
			publicationAuthor:'Patania 1995',
			publicationYear:1991,
			avg_reduction:1.425E0,
			avg_stddev:0.406201920231798E0,
			sampleCount:8
		).save()

		new ResearchData(researchId:61,year:1993,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Harrington, G.W. (2003). Journ. AWWA, 95(12):95-104. ',													publicationAuthor:'Harrington 2003',	publicationYear:1993,avg_reduction:1.42555994729908E0,	avg_stddev:0.1986062898539E0,	sampleCount:14).save()
		new ResearchData(researchId:62,year:1994,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:1994,avg_reduction:1.49545454545455E0,	avg_stddev:0.325835589168574E0,	sampleCount:22).save()
		new ResearchData(researchId:63,year:1994,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:1994,avg_reduction:1.51428571428571E0,	avg_stddev:0.313201593379148E0,	sampleCount:7).save()
		new ResearchData(researchId:64,year:1994,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Harrington, G.W. (2003). Journ. AWWA, 95(12):95-104. ',													publicationAuthor:'Harrington 2003',	publicationYear:1994,avg_reduction:1.67360517329461E0,	avg_stddev:0.407036848630971E0,	sampleCount:14).save()
		new ResearchData(researchId:65,year:1994,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Nobel, P.J. (1999). Kiwa report SWI 99.180, in Dutch',													publicationAuthor:'Nobel 1999',			publicationYear:1994,avg_reduction:1.75E0,				avg_stddev:0.212132034355964E0,	sampleCount:2).save()
		new ResearchData(researchId:66,year:1994,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PROCEEDING',	publicationDescription:'Nieminski, E.C. (1994).  In Proc. AWWA Annual Conference, 1994.',										publicationAuthor:'Nieminsky 1994',		publicationYear:1994,avg_reduction:1.92E0,				avg_stddev:0.303315017762061E0,	sampleCount:5).save()
		new ResearchData(researchId:67,year:1994,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:1994,avg_reduction:1.95454545454545E0,	avg_stddev:0.537333483720559E0,	sampleCount:11).save()
		new ResearchData(researchId:68,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:1995,avg_reduction:1.96666666666667E0,	avg_stddev:0.618600571181975E0,	sampleCount:6).save()
		new ResearchData(researchId:69,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:1995,avg_reduction:2.08571428571429E0,	avg_stddev:0.241029537806548E0,	sampleCount:7).save()
		new ResearchData(researchId:70,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PROCEEDING',	publicationDescription:'West, Th. (1994). In Proc. Annual Conf. AWWA, Denver CO',												publicationAuthor:'West 1994',			publicationYear:1995,avg_reduction:2.22E0,				avg_stddev:0.130384048104053E0,	sampleCount:5).save()
		new ResearchData(researchId:71,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Nieminski, E.C., (1995). Jour. AWWA 87(9): 96-106',														publicationAuthor:'Nieminsky 1995',		publicationYear:1995,avg_reduction:2.26666666666667E0,	avg_stddev:0.472581562625259E0,	sampleCount:3).save()
		new ResearchData(researchId:72,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PROCEEDING',	publicationDescription:'West, Th. (1994). In Proc. Annual Conf. AWWA, Denver CO',												publicationAuthor:'West 1994',			publicationYear:1995,avg_reduction:2.3E0,				avg_stddev:0.173205080756888E0,	sampleCount:5).save()
		new ResearchData(researchId:73,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Hijnen, W.A.M.(2003). Kiwa report KWR 02.095B, in Dutch',												publicationAuthor:'Hijnen 2003',		publicationYear:1995,avg_reduction:2.3E0,				avg_stddev:0.0E0,				sampleCount:1).save()
		new ResearchData(researchId:74,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Akiba, M., (2002). Wat. Sci. Tech.:Water suppl. 2(30): 73-80.',											publicationAuthor:'Akiba 2002',			publicationYear:1995,avg_reduction:2.34285714285714E0,	avg_stddev:0.637330743170669E0,	sampleCount:7).save()
		new ResearchData(researchId:75,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'LeChevallier, M.W. (1992). J. Am. Water Works Assoc., 84(12): 54B60 (1992).',							publicationAuthor:'LeChevallier 1992',	publicationYear:1995,avg_reduction:2.4E0,				avg_stddev:0.0E0,				sampleCount:1).save()
		new ResearchData(researchId:76,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Hashimoto, A., (2001). Wat. Sci. Techn. 43(12):89-92. ',												publicationAuthor:'Hasimoto 2001',		publicationYear:1995,avg_reduction:2.5E0,				avg_stddev:0.0E0,				sampleCount:1).save()
		new ResearchData(researchId:77,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PROC',			publicationDescription:'West, Th. (1994). In Proc. Annual Conf. AWWA, Denver CO',												publicationAuthor:'West 1994',			publicationYear:1995,avg_reduction:2.64E0,				avg_stddev:0.482700735445886E0,	sampleCount:5).save()
		new ResearchData(researchId:78,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Akiba, M., (2002). Wat. Sci. Tech.:Water suppl. 2(30: 73-80.',											publicationAuthor:'Akiba 2002',			publicationYear:1995,avg_reduction:2.7625E0,			avg_stddev:0.831414457415794E0,	sampleCount:8).save()
		new ResearchData(researchId:79,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PROCEEDING',	publicationDescription:'Nieminski, E.C. (1994). In Proc. AWWA Annual Conference, 1994.',										publicationAuthor:'Nieminsky 1994',		publicationYear:1995,avg_reduction:2.84E0,				avg_stddev:0.605896947600094E0,	sampleCount:10).save()
		new ResearchData(researchId:80,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Hancock, C.M., (1996). JAWWA 88 (12), 24-34.',															publicationAuthor:'Hancock 1996',		publicationYear:1995,avg_reduction:2.93918918918919E0,	avg_stddev:1.23150693729648E0,	sampleCount:111).save()
		new ResearchData(researchId:81,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PROCEEDING',	publicationDescription:'West, Th. (1994). In Proc. Annual Conf. AWWA, Denver CO',												publicationAuthor:'West 1994',			publicationYear:1995,avg_reduction:2.96E0,				avg_stddev:0.502991053598372E0,	sampleCount:5).save()
		new ResearchData(researchId:82,year:1995,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Nieminski, E.C., (1995). Jour. AWWA 87(9): 96-106',														publicationAuthor:'Nieminsky 1995',		publicationYear:1995,avg_reduction:2.9625E0,			avg_stddev:0.665340943748817E0,	sampleCount:8).save()
		new ResearchData(researchId:83,year:1996,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:1996,avg_reduction:2.96363636363636E0,	avg_stddev:0.461026522605214E0,	sampleCount:11).save()
		new ResearchData(researchId:84,year:1997,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:1997,avg_reduction:3.04545454545455E0,	avg_stddev:0.324737656354398E0,	sampleCount:22).save()
		new ResearchData(researchId:85,year:1997,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:0,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Akiba, M., (2002). Wat. Sci. Tech.:Water suppl. 2(30: 73-80.',											publicationAuthor:'Akiba 2002',			publicationYear:1997,avg_reduction:3.475E0,				avg_stddev:0.388219378334313E0,	sampleCount:8).save()
		new ResearchData(researchId:86,year:1997,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'States, S.,  (1997). JAWWA, 89(9):74-83.',																publicationAuthor:'States 1997',		publicationYear:1997,avg_reduction:3.5E0,				avg_stddev:0.0E0,				sampleCount:1).save()
		new ResearchData(researchId:87,year:1999,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PROCEEDING',	publicationDescription:'Yates, R.S.,  (1997).  Int. Symp. on Waterborne Cryptosporidium, ed. C.R. Fricker, J.J. Clancy, P.A. Rochelle, Newport Beach, US, 1997, p. 281-290.',publicationAuthor:'Yates 1997a',publicationYear:1999,avg_reduction:3.5E0,avg_stddev:0.0E0,sampleCount:1).save()
		new ResearchData(researchId:88,year:2001,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'States, S.,  (1997). JAWWA, 89(9):74-83.',																publicationAuthor:'States 1997',		publicationYear:2001,avg_reduction:3.5E0,				avg_stddev:0.0E0,				sampleCount:1).save()
		new ResearchData(researchId:89,year:2001,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:2001,avg_reduction:3.9E0,				avg_stddev:0.592814112035608E0,	sampleCount:8).save()
		new ResearchData(researchId:90,year:2001,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:2001,avg_reduction:4.15714285714286E0,	avg_stddev:0.660447178955649E0,	sampleCount:7).save()
		new ResearchData(researchId:91,year:2002,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Payment, P. (1993). Appl. Environ. Microbiol. 59(8): 2418-2424.',										publicationAuthor:'Payment 1993',		publicationYear:2002,avg_reduction:4.6E0,				avg_stddev:0.0E0,				sampleCount:1).save()
		new ResearchData(researchId:92,year:2002,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:2002,avg_reduction:4.78181818181818E0,	avg_stddev:0.672038959909591E0,	sampleCount:11).save()
		new ResearchData(researchId:93,year:2002,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Dugan, N.R., (2001).  Journal of the AWWA, 93(12):64-76.',												publicationAuthor:'Dugan 2001',			publicationYear:2002,avg_reduction:4.975E0,				avg_stddev:0.35939764421413E0,	sampleCount:4).save()
		new ResearchData(researchId:94,year:2003,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:2003,avg_reduction:5.01363636363636E0,	avg_stddev:0.61666959166266E0,	sampleCount:22).save()
		new ResearchData(researchId:95,year:2003,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'PUBLICATION',	publicationDescription:'Cornwell, D.A. (2001). Jour. AWWA April, 2001: 153-162.',												publicationAuthor:'Cornwell 2001',		publicationYear:2003,avg_reduction:5.35E0,				avg_stddev:0.494974746830583E0,	sampleCount:2).save()
		new ResearchData(researchId:96,year:2003,organismType:'CRYPTOSPORIDIUM',orgainsm:'',organismTarget:1,processType:'CONVENTIONAL',publicationType:'REPORT',		publicationDescription:'Patania, N.L. (1995). Denver, Colo.: Awwa Research Foundation and American Water Works Association.',	publicationAuthor:'Patania 1995',		publicationYear:2003,avg_reduction:5.45E0,				avg_stddev:0.494974746830583E0,	sampleCount:11).save()	
    }
	
    def destroy = {
    }
}
