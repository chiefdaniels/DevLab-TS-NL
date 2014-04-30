package dev.lab.qmra

import dev.lab.qmra.ResearchData
import dev.lab.qmra.enums.*

class QuestionaireController {

	static allowedMethods = [result: ["POST","GET"]]
	static defaultAction = "init"
	
	def init() {
		
	}

	def index() { }
	
    def result() { 
		println params
		def view = 'result'
		if (params.OrganismType == 'Bacteria'){
			forward action:'bacteria'
		} else {
			def resdata=ResearchData.findByOrganismType(params.OrganismType)
			render view:view,model:[answer:params.OrganismType?:'niets!',resdata:resdata]
		}
	}
	
	def bacteria(){
		
	}
}
