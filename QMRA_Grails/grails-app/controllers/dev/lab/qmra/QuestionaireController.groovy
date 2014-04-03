package dev.lab.qmra

class QuestionaireController {

	static allowedMethods = [result: ["POST","GET"]]
	static defaultAction = "init"
	
	def init() {
		
	}

	def index() { }
	
    def result() { 
		println params
		
		[answer:params.test?:'niets!']
	}
}
