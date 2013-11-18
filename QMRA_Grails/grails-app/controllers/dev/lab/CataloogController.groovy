

package dev.lab

import dev.lab.Boek

class CataloogController {

    def index() {
		[cataloog:Boek.findAll()]
	}
}
