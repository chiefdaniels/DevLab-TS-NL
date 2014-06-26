package dev.lab.tutorial



import org.junit.*
import grails.test.mixin.*

@TestFor(BoekController)
@Mock(Boek)
class BoekControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/boek/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.boekInstanceList.size() == 0
        assert model.boekInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.boekInstance != null
    }

    void testSave() {
        controller.save()

        assert model.boekInstance != null
        assert view == '/boek/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/boek/show/1'
        assert controller.flash.message != null
        assert Boek.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/boek/list'

        populateValidParams(params)
        def boek = new Boek(params)

        assert boek.save() != null

        params.id = boek.id

        def model = controller.show()

        assert model.boekInstance == boek
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/boek/list'

        populateValidParams(params)
        def boek = new Boek(params)

        assert boek.save() != null

        params.id = boek.id

        def model = controller.edit()

        assert model.boekInstance == boek
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/boek/list'

        response.reset()

        populateValidParams(params)
        def boek = new Boek(params)

        assert boek.save() != null

        // test invalid parameters in update
        params.id = boek.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/boek/edit"
        assert model.boekInstance != null

        boek.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/boek/show/$boek.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        boek.clearErrors()

        populateValidParams(params)
        params.id = boek.id
        params.version = -1
        controller.update()

        assert view == "/boek/edit"
        assert model.boekInstance != null
        assert model.boekInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/boek/list'

        response.reset()

        populateValidParams(params)
        def boek = new Boek(params)

        assert boek.save() != null
        assert Boek.count() == 1

        params.id = boek.id

        controller.delete()

        assert Boek.count() == 0
        assert Boek.get(boek.id) == null
        assert response.redirectedUrl == '/boek/list'
    }
}
