package dev.lab.tutorial

import dev.lab.tutorial.Boek
import org.springframework.dao.DataIntegrityViolationException

class BoekController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [boekInstanceList: Boek.list(params), boekInstanceTotal: Boek.count()]
    }

    def create() {
        [boekInstance: new Boek(params)]
    }

    def save() {
        def boekInstance = new Boek(params)
        if (!boekInstance.save(flush: true)) {
            render(view: "create", model: [boekInstance: boekInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'boek.label', default: 'Boek'), boekInstance.id])
        redirect(action: "show", id: boekInstance.id)
    }

    def show(Long id) {
        def boekInstance = Boek.get(id)
        if (!boekInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'boek.label', default: 'Boek'), id])
            redirect(action: "list")
            return
        }

        [boekInstance: boekInstance]
    }

    def edit(Long id) {
        def boekInstance = Boek.get(id)
        if (!boekInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'boek.label', default: 'Boek'), id])
            redirect(action: "list")
            return
        }

        [boekInstance: boekInstance]
    }

    def update(Long id, Long version) {
        def boekInstance = Boek.get(id)
        if (!boekInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'boek.label', default: 'Boek'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (boekInstance.version > version) {
                boekInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'boek.label', default: 'Boek')] as Object[],
                          "Another user has updated this Boek while you were editing")
                render(view: "edit", model: [boekInstance: boekInstance])
                return
            }
        }

        boekInstance.properties = params

        if (!boekInstance.save(flush: true)) {
            render(view: "edit", model: [boekInstance: boekInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'boek.label', default: 'Boek'), boekInstance.id])
        redirect(action: "show", id: boekInstance.id)
    }

    def delete(Long id) {
        def boekInstance = Boek.get(id)
        if (!boekInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'boek.label', default: 'Boek'), id])
            redirect(action: "list")
            return
        }

        try {
            boekInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'boek.label', default: 'Boek'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'boek.label', default: 'Boek'), id])
            redirect(action: "show", id: id)
        }
    }
}
