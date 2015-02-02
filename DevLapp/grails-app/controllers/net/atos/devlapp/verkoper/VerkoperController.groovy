package net.atos.devlapp.verkoper



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class VerkoperController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Verkoper.list(params), model:[verkoperInstanceCount: Verkoper.count()]
    }

    def show(Verkoper verkoperInstance) {
        respond verkoperInstance
    }

    def create() {
        respond new Verkoper(params)
    }

    @Transactional
    def save(Verkoper verkoperInstance) {
        if (verkoperInstance == null) {
            notFound()
            return
        }

        if (verkoperInstance.hasErrors()) {
            respond verkoperInstance.errors, view:'create'
            return
        }

        verkoperInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'verkoper.label', default: 'Verkoper'), verkoperInstance.id])
                redirect verkoperInstance
            }
            '*' { respond verkoperInstance, [status: CREATED] }
        }
    }

    def edit(Verkoper verkoperInstance) {
        respond verkoperInstance
    }

    @Transactional
    def update(Verkoper verkoperInstance) {
        if (verkoperInstance == null) {
            notFound()
            return
        }

        if (verkoperInstance.hasErrors()) {
            respond verkoperInstance.errors, view:'edit'
            return
        }

        verkoperInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Verkoper.label', default: 'Verkoper'), verkoperInstance.id])
                redirect verkoperInstance
            }
            '*'{ respond verkoperInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Verkoper verkoperInstance) {

        if (verkoperInstance == null) {
            notFound()
            return
        }

        verkoperInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Verkoper.label', default: 'Verkoper'), verkoperInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'verkoper.label', default: 'Verkoper'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
