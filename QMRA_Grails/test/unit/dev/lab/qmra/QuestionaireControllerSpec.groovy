package dev.lab.qmra

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(QuestionaireController)
class QuestionaireControllerSpec extends Specification {

    @Unroll
    def "Controller action result aanroepen met waarde #testWaarde geeft als resultaat #verwachtAntwoord"() {
        given:
        params.test = testWaarde

        when:
        def result = controller.result()

        then:
        result.answer == verwachtAntwoord

        where:
        testWaarde | verwachtAntwoord
        null       | 'niets!'
        'Ja'       | 'Ja'
    }
}
