package dev.lab.qmra

class Chlorine_Constant {

	//TODO: implement me! see Spring/../qmra.script for more info

    double chlorineConcentration
	double temperature    
    double a
	double b
    	
    static constraints = {
        chlorineConcentration(nullable:false,blank:false) 
		temperature(nullable:false,blank:false)
		a(nullable:true)
		b(nullable:true)
    }
}


