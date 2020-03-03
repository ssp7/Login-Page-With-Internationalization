package login_page

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import spock.lang.Unroll


class PersonControllerSpec extends Specification implements ControllerUnitTest<PersonController>, DomainUnitTest<Person> {

    def 'Test the index action returns the correct model'() {
        given:
        List<Person> samplePerson = [new Person(firstName: "Soham", lastName: "Patel", emailAddress: "valid@email.com", userName: "spy", password: "12345678"),
                                     new Person(firstName: "HD", lastName: "Zahur", emailAddress: "valid2@email.com", userName: "spy1", password: "12345678")
        ]
        controller.personService = Stub(PersonService) {
            list() >> samplePerson
            count() >> samplePerson.size()
        }

        when: 'The index action is executed'
        controller.list()

        then: 'The model is correct'
        model.list
        model.list.size() == samplePerson.size()
        model.list.find { it.firstName == "Soham" && it.emailAddress == 'valid@email.com' }
        model.list.find { it.lastName == 'Zahur' && it.firstName == 'HD' }
        !model.list.find { it.userName == 'spykid001' }
        model.list.size() == samplePerson.size()
    }

    def 'If you dont provide proper parameters to the create page then you will remain on the create page'() {
        when:
        request.contentType == FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.save()
        then:
        model.person
        view == 'create'
    }

    def 'If you provide proper parameters to the create page then it will take you to show page'() {
        given:
        String firstName = "soham"
        String lastName = "Patel"
        String userName = "sp1301"
        String email = "email@valid.com"
        String password = "12341234"
        String confirmPassword = "12341234"
        controller.personService = Stub(PersonService) {
            save() >> new Person(firstName: firstName, lastName: lastName, userName: userName, emailAddress: email, password: password, confirmPassword: confirmPassword)
            //  read(_) >> new Person(firstName: firstName,lastName: lastName,userName: userName,emailAddress: email,password: password,confirmPassword: confirmPassword)
        }
        when:
        request.method = "POST"
        request.contentType = FORM_CONTENT_TYPE
        params['firstName'] = firstName
        params['lastName'] = lastName
        params['userName'] = userName
        params['emailAddress'] = email
        params['password'] = password
        params['confirmPassword'] = confirmPassword
        controller.save()
        then:
        flash.message
        and:
        response.redirectedUrl.startsWith("/person/show")
        and:
        response.status == 302
    }

    def 'JSON payload is doomed to the service object. If the person is saved then a 201 is returned'() {
        given:
        String firstName = "soham"
        String lastName = "Patel"
        String userName = "sp1301"
        String email = "email@valid.com"
        String password = "12341234"
        String confirmPassword = "12341234"
        controller.personService = Stub(PersonService) {
            save() >> new Person(firstName: firstName, lastName: lastName, userName: userName, emailAddress: email, password: password, confirmPassword: confirmPassword)
            //  read(_) >> new Person(firstName: firstName,lastName: lastName,userName: userName,emailAddress: email,password: password,confirmPassword: confirmPassword)
        }
        when:
        request.method = 'POST'
        request.json = '{"firstName":"' + firstName + '","lastName":' + lastName + '","userName":' + userName + '","emailAddress":' + email + '","password":' + password + '","lastName":' + lastName + '","confirmPassoword":' + confirmPassword + '}'
        controller.save()
        then:
        response.status == 200
    }

    def "PersonController.save does not accept #method requests"(String method) {
        when:
        request.method = method
        controller.save()

        then:
        response.status == 405

        where:
        method << ['PATCH', 'DELETE', 'GET', 'PUT']
    }

    def "PersonController.save accepts POST requests"() {
        when:
        request.method = 'POST'
        controller.save()

        then:
        response.status == 200
    }

    def "when we edit a person and dont provide proper parameters then we stay on edit page only"() {
        when:
        request.contentType == FORM_CONTENT_TYPE
        request.method = 'POST'
        controller.edit()
        then:
        model.person
        view == 'edit'
    }

    def "when we delete a person it will go to the LoginPage page"() {
        when:
        request.contentType == FORM_CONTENT_TYPE
        request.method = 'DELETE'
        controller.delete()
        then:
        view == '/person/LoginPage'
    }
}