package dev.lab.tutorial

import dev.lab.tutorial.Boek

class BooksService {

    def getCataloog() {
        Boek.findAll()
    }
}
