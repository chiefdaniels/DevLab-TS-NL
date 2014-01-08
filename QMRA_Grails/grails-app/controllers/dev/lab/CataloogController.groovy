package dev.lab

import dev.lab.Boek
import grails.converters.JSON

class CataloogController {

    BooksService booksService

    def index() {
        render (view:'index',model:[cataloog:Boek.findAll()])
    }

    def template() {
        render (view:'template',model:[cataloog:Boek.findAll()])
    }

    def string(){
        render booksService.cataloog    as JSON
    }

    def moresense(){
        render booksService.cataloog*.description()    as JSON
    }

    def reuse() {
    }

    def reuse_part(){
        [cataloog:booksService.cataloog]
    }

}
