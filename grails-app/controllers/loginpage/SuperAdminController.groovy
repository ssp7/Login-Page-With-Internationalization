package loginpage

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

@Secured(['ROLE_SUPERADMIN'])
class SuperAdminController {


    PersonService personService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def superAdminShow(Long id) {
        respond personService.get(Person.findById(id))
    }


    def superAdminList() {
        List<Person> list = personService.list()
        render(view: 'superAdminList', model: [list: list])
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
                redirect(action: 'superAdminList')
            }
            '*' { respond person, [status: CREATED] }
        }
    }

    def delete(Person person) {

        if (person == null) {
            redirect(controller: 'person', action: 'notFound')
            return
        }
        personService.delete(person)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(default: 'login_page.Person')])
                redirect(action: 'superAdminList')
            }
            '*' { render status: OK, view: 'superAdminList' }
        }

    }

    def edit(Person p) {
        respond p
    }

    def update(Person person) {

        if (person.hasErrors()) {
            respond(person.errors, view: 'edit')
            return
        }
        personService.save(person)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'person.label', default: 'login_page.Person'), person.id])
                redirect(action: 'superAdminList')
            }
            //  '*' { redirect(action: 'list')}
        }
    }

}
