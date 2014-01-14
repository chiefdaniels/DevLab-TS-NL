package dev.lab.tutorial

import grails.converters.JSON

class Cataloog3Controller {

    BooksService booksService
    def index() {
     println 'hello'
    }

    def test(){
        //[boodschap:Boek.findAll()*.description()]
        [boodschap:booksService.cataloog]
    }

}
