package loginpage

import grails.testing.mixin.integration.Integration
import org.springframework.test.annotation.Rollback
import spock.lang.Specification

@Integration
@Rollback
class PersonSpec extends Specification {

    void setupData(){
    Person p = new Person(firstName: "Soham",lastName: "Patel",userName: "spykid007", emailAddress: "valid@protonmail.com",password: "12345678").save()

    }


    void "expecting to save the p object"() {
        given:
        setupData()
        expect:
            Person.count() ==1
    }
    void "expecting to be able to delete p object"(){

        expect:
        p.delete()
    }
    void "expecting to validate"(){
        given:
        Person p = new Person(firstName: "Soham", lastName: "patel",userName: "spa",password: "23",emailAddress: "valid@ema.com")
        when:
        p.validate()
        then:
        !p.validate()
        p.errors.getFieldError('password').code == 'minSize'

    }
    void "expecting to get the list of all the person objects"(){
        expect:
        personService.listPersons()
    }
}
