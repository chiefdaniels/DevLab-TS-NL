package net.atos.devlapp.bestelling



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class BestellingController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Bestelling.list(params), model:[bestellingInstanceCount: Bestelling.count()]
    }

    def show(Bestelling bestellingInstance) {
        respond bestellingInstance
    }

    def create() {
        respond new Bestelling(params)
    }

    @Transactional
    def save(Bestelling bestellingInstance) {
        if (bestellingInstance == null) {
            notFound()
            return
        }

        if (bestellingInstance.hasErrors()) {
            respond bestellingInstance.errors, view:'create'
            return
        }

        bestellingInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'bestelling.label', default: 'Bestelling'), bestellingInstance.id])
                redirect bestellingInstance
            }
            '*' { respond bestellingInstance, [status: CREATED] }
        }
    }

    def edit(Bestelling bestellingInstance) {
        respond bestellingInstance
    }

    @Transactional
    def update(Bestelling bestellingInstance) {
        if (bestellingInstance == null) {
            notFound()
            return
        }

        if (bestellingInstance.hasErrors()) {
            respond bestellingInstance.errors, view:'edit'
            return
        }

        bestellingInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Bestelling.label', default: 'Bestelling'), bestellingInstance.id])
                redirect bestellingInstance
            }
            '*'{ respond bestellingInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Bestelling bestellingInstance) {

        if (bestellingInstance == null) {
            notFound()
            return
        }

        bestellingInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Bestelling.label', default: 'Bestelling'), bestellingInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'bestelling.label', default: 'Bestelling'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
