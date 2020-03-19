package login_page

import grails.plugin.springsecurity.annotation.Secured
import org.slf4j.LoggerFactory
import org.springframework.context.MessageSource
import org.springframework.security.core.context.SecurityContextHolder

import java.util.logging.Logger

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND

class PersonController {

    Person currentPerson
    PersonService personService
    MessageSource messageSource
    static allowedMethods = [save: "POST", update: "PUT",listupdate:"PUT", delete: "DELETE"]

    private Person refreshCurrentUser() {
        currentPerson = Person.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName())
    }

    def show(Long id) {
        respond personService.get(Person.findById(id))
    }

    @Secured(['permitAll'])
    def create() {

        respond new Person(params)
    }

    @Secured(['permitAll'])
    def validate(Person person) {
        personService.validate(person)
        for (error in person.errors) {

            // lookup the error message
            Locale locale = RCU.getLocale(request)
            String errorMsg = messageSource.getMessage(error)

            println errorMsg
        }
    }


    @Secured(['permitAll'])
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
                redirect(action: 'show', id: person.id)
                //redirect(controller: 'admin', action: 'list')
            }
         //   '*' { respond person, [status: OK] }
        }
    }

    def delete(Person person) {
        if (person == null) {
            notFound()
            return
        }
        personService.delete(person)
        redirect( action:'LoginPage')
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(default: 'login_page.Person')])

            }
            '*' { render status: NOT_FOUND, view: '/login/index' }
        }
    }

    @Secured(['ROLE_USER','ROLE_ADMIN','ROLE_SUPERADMIN'])
    def LoginPage() {
          refreshCurrentUser()
        if (currentPerson == null) {
            notFound()
        }else {
            if(currentPerson.getAuthorities()[0].getAuthority()=="ROLE_SUPERADMIN"){
                redirect(controller:'superAdmin', action: 'superAdminShow', id: currentPerson.id)
            }
           else if(currentPerson.getAuthorities()[0].getAuthority()=="ROLE_ADMIN"){
                redirect(controller:'admin', action: 'adminShow', id: currentPerson.id)
            }
            else if(currentPerson.getAuthorities()[0].getAuthority()=="ROLE_USER"){
                redirect(action: 'show', id: currentPerson.id)
            }
        }
    }
}
