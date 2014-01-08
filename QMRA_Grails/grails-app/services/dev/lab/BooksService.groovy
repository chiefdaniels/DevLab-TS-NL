package dev.lab

class BooksService {

    def getCataloog() {
        Boek.findAll()
    }
}
