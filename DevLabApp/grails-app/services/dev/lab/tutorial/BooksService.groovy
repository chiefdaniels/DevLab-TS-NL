package dev.lab.tutorial

class BooksService {

    def getCataloog() {
        Boek.findAll()
    }
}
