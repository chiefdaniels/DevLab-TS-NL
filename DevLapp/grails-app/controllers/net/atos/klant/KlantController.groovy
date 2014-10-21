package net.atos.klant



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class KlantController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Klant.list(params), model:[klantInstanceCount: Klant.count()]
    }

    def show(Klant klantInstance) {
        respond klantInstance
    }

    def create() {
        respond new Klant(params)
    }

    @Transactional
    def save(Klant klantInstance) {
        if (klantInstance == null) {
            notFound()
            return
        }

        if (klantInstance.hasErrors()) {
            respond klantInstance.errors, view:'create'
            return
        }

        klantInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'klant.label', default: 'Klant'), klantInstance.id])
                redirect klantInstance
            }
            '*' { respond klantInstance, [status: CREATED] }
        }
    }

    def edit(Klant klantInstance) {
        respond klantInstance
    }

    @Transactional
    def update(Klant klantInstance) {
        if (klantInstance == null) {
            notFound()
            return
        }

        if (klantInstance.hasErrors()) {
            respond klantInstance.errors, view:'edit'
            return
        }

        klantInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Klant.label', default: 'Klant'), klantInstance.id])
                redirect klantInstance
            }
            '*'{ respond klantInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Klant klantInstance) {

        if (klantInstance == null) {
            notFound()
            return
        }

        klantInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Klant.label', default: 'Klant'), klantInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'klant.label', default: 'Klant'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
