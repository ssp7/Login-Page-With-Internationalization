package login_page


import org.springframework.context.MessageSource

import static org.springframework.http.HttpStatus.*

class PersonController {

    PersonService personService
    MessageSource messageSource
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond personService.list(), model: [personCount: personService.list()]
    }

    def show(Person person) {

        respond person
    }

    def create() {

        respond new Person(params)
    }

    def validate(Person person) {
        personService.validate(person)
        for (error in person.errors) {

            // lookup the error message
            Locale locale = RCU.getLocale(request)
            String errorMsg = messageSource.getMessage(error)

            println errorMsg
        }
    }
    def save(Person person) {
        if (person == null) {
            render status: NOT_FOUND
        }
        if (person.hasErrors()) {
            respond(person.errors, view: 'create')
            return
        }
        personService.save(person)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'person.label', default: 'login_page.Person'), person.id])
                redirect person
            }
            '*' { respond person, [status: CREATED] }
        }
    }

    def edit(Person person) {
        respond person
    }

    def update(Person person) {
        if (person == null) {
            notFound()
            return
        }

        if (person.hasErrors()) {
            respond(person.errors, view: 'edit')
            return
        }
        personService.save(person)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'person.label', default: 'login_page.Person'), person.id])
                redirect person
            }
            '*' { respond person, [status: OK] }
        }
    }

    def delete(Person person) {
        if (person == null) {
            notFound()
            return
        }

        personService.delete(person)
        render(view: '/layouts/LoginPage')
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(default: 'login_page.Person'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

    def list() {
        render(view: '/List', model: [list: personService.list()])
    }

    def login() {

        Person person = personService.login(params.userName, params.password)
        if (person == null) {
            notFound()
            return
        }
        if (person.hasErrors()) {
            respond(person.errors, view: '/layout/LoginPage')
            return
        }
        respond person
    }
}
