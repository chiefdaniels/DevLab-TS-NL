package dev.lab.qmra

class QuestionaireController {

	static allowedMethods = [result: ["POST","GET"]]
	
	def index() {

    }
	
    def result() { 
		println params
		
		[answer:params.test?:'niets!']
	}
}
