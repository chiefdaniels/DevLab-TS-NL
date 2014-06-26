package dev.lab.tutorial

class Entry {

	int dag
	int aantal
	
    static constraints = {
		dag(nullable:false,blank:false)
		aantal(nullable:false,blank:false)
    }

}
