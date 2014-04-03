package dev.lab.qmra

import org.springframework.dao.DataIntegrityViolationException

class Critical_ConditionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [critical_ConditionInstanceList: Critical_Condition.list(params), critical_ConditionInstanceTotal: Critical_Condition.count()]
    }

    def create() {
        [critical_ConditionInstance: new Critical_Condition(params)]
    }

    def save() {
        def critical_ConditionInstance = new Critical_Condition(params)
        if (!critical_ConditionInstance.save(flush: true)) {
            render(view: "create", model: [critical_ConditionInstance: critical_ConditionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'critical_Condition.label', default: 'Critical_Condition'), critical_ConditionInstance.id])
        redirect(action: "show", id: critical_ConditionInstance.id)
    }

    def show(Long id) {
        def critical_ConditionInstance = Critical_Condition.get(id)
        if (!critical_ConditionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'critical_Condition.label', default: 'Critical_Condition'), id])
            redirect(action: "list")
            return
        }

        [critical_ConditionInstance: critical_ConditionInstance]
    }

    def edit(Long id) {
        def critical_ConditionInstance = Critical_Condition.get(id)
        if (!critical_ConditionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'critical_Condition.label', default: 'Critical_Condition'), id])
            redirect(action: "list")
            return
        }

        [critical_ConditionInstance: critical_ConditionInstance]
    }

    def update(Long id, Long version) {
        def critical_ConditionInstance = Critical_Condition.get(id)
        if (!critical_ConditionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'critical_Condition.label', default: 'Critical_Condition'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (critical_ConditionInstance.version > version) {
                critical_ConditionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'critical_Condition.label', default: 'Critical_Condition')] as Object[],
                          "Another user has updated this Critical_Condition while you were editing")
                render(view: "edit", model: [critical_ConditionInstance: critical_ConditionInstance])
                return
            }
        }

        critical_ConditionInstance.properties = params

        if (!critical_ConditionInstance.save(flush: true)) {
            render(view: "edit", model: [critical_ConditionInstance: critical_ConditionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'critical_Condition.label', default: 'Critical_Condition'), critical_ConditionInstance.id])
        redirect(action: "show", id: critical_ConditionInstance.id)
    }

    def delete(Long id) {
        def critical_ConditionInstance = Critical_Condition.get(id)
        if (!critical_ConditionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'critical_Condition.label', default: 'Critical_Condition'), id])
            redirect(action: "list")
            return
        }

        try {
            critical_ConditionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'critical_Condition.label', default: 'Critical_Condition'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'critical_Condition.label', default: 'Critical_Condition'), id])
            redirect(action: "show", id: id)
        }
    }
}
