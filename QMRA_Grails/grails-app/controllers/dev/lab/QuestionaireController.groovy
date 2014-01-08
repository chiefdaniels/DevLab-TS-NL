package dev.lab

class QuestionaireController {

	static allowedMethods = [result: ["POST","GET"]]
	
	def index() {}
	
    def result() { 
		println params
		
		[answer:params.test]
	}
}
