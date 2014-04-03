package dev.lab.qmra



import org.junit.*
import grails.test.mixin.*

@TestFor(Critical_ConditionController)
@Mock(Critical_Condition)
class Critical_ConditionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/critical_Condition/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.critical_ConditionInstanceList.size() == 0
        assert model.critical_ConditionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.critical_ConditionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.critical_ConditionInstance != null
        assert view == '/critical_Condition/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/critical_Condition/show/1'
        assert controller.flash.message != null
        assert Critical_Condition.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/critical_Condition/list'

        populateValidParams(params)
        def critical_Condition = new Critical_Condition(params)

        assert critical_Condition.save() != null

        params.id = critical_Condition.id

        def model = controller.show()

        assert model.critical_ConditionInstance == critical_Condition
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/critical_Condition/list'

        populateValidParams(params)
        def critical_Condition = new Critical_Condition(params)

        assert critical_Condition.save() != null

        params.id = critical_Condition.id

        def model = controller.edit()

        assert model.critical_ConditionInstance == critical_Condition
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/critical_Condition/list'

        response.reset()

        populateValidParams(params)
        def critical_Condition = new Critical_Condition(params)

        assert critical_Condition.save() != null

        // test invalid parameters in update
        params.id = critical_Condition.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/critical_Condition/edit"
        assert model.critical_ConditionInstance != null

        critical_Condition.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/critical_Condition/show/$critical_Condition.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        critical_Condition.clearErrors()

        populateValidParams(params)
        params.id = critical_Condition.id
        params.version = -1
        controller.update()

        assert view == "/critical_Condition/edit"
        assert model.critical_ConditionInstance != null
        assert model.critical_ConditionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/critical_Condition/list'

        response.reset()

        populateValidParams(params)
        def critical_Condition = new Critical_Condition(params)

        assert critical_Condition.save() != null
        assert Critical_Condition.count() == 1

        params.id = critical_Condition.id

        controller.delete()

        assert Critical_Condition.count() == 0
        assert Critical_Condition.get(critical_Condition.id) == null
        assert response.redirectedUrl == '/critical_Condition/list'
    }
}
