package net.atos.devLapp.artikel



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ArtikelController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Artikel.list(params), model:[artikelInstanceCount: Artikel.count()]
    }

    def show(Artikel artikelInstance) {
        respond artikelInstance
    }

    def create() {
        respond new Artikel(params)
    }

    @Transactional
    def save(Artikel artikelInstance) {
        if (artikelInstance == null) {
            notFound()
            return
        }

        if (artikelInstance.hasErrors()) {
            respond artikelInstance.errors, view:'create'
            return
        }

        artikelInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'artikel.label', default: 'Artikel'), artikelInstance.id])
                redirect artikelInstance
            }
            '*' { respond artikelInstance, [status: CREATED] }
        }
    }

    def edit(Artikel artikelInstance) {
        respond artikelInstance
    }

    @Transactional
    def update(Artikel artikelInstance) {
        if (artikelInstance == null) {
            notFound()
            return
        }

        if (artikelInstance.hasErrors()) {
            respond artikelInstance.errors, view:'edit'
            return
        }

        artikelInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Artikel.label', default: 'Artikel'), artikelInstance.id])
                redirect artikelInstance
            }
            '*'{ respond artikelInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Artikel artikelInstance) {

        if (artikelInstance == null) {
            notFound()
            return
        }

        artikelInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Artikel.label', default: 'Artikel'), artikelInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'artikel.label', default: 'Artikel'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
