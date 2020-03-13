package login_page

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.context.MessageSource

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND


@Secured(['permitAll'])
class PersonController {

    PersonService personService
    MessageSource messageSource
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]


    def show(Long id) {
        respond personService.get(Person.findById(id))
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
                redirect(action: 'show', id: person.id)
            }
            '*' { respond person, [status: CREATED] }
        }
    }

    def edit(Person p) {
        respond p
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
                redirectredirect(action: 'show', id: person.id)
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
        render(view: '/person/LoginPage')
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(default: 'login_page.Person')])
                //redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND, view: '/person/LoginPage' }
        }
    }

    def list() {
        List<Person> list = personService.list()
        render(view: '/person/List', model: [list: list])
    }

    def LoginPage() {

       Person p = personService.login(params.userName, params.password)
        if (p == null) {
            notFound()
        }else {
            redirect (action: 'show',id: p.id)
        }
    }
}
