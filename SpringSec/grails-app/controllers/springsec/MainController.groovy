package springsec

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class MainController {

    def index() {
        def username = "spykid007"
        [user: username]
    }
}
