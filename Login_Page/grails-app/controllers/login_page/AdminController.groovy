package login_page

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.context.MessageSource

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK


@Secured(['ROLE_ADMIN'])
class AdminController {

    PersonService personService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def adminShow(Long id) {
        respond personService.get(Person.findById(id))
    }


    def list() {
        List<Person> list = personService.list()
        render(view: 'List', model: [list: list])
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
                flash.message = message(code: 'default.created.message')
                redirect(action: 'list')
            }
            '*' { respond person, [status: CREATED] }
        }
    }

}
