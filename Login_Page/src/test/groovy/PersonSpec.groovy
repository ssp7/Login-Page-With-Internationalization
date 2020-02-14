

import grails.testing.gorm.DomainUnitTest
import login_page.Person
import spock.lang.Specification

class PersonSpec extends Specification implements DomainUnitTest<Person> {


    Person p = new Person(firstName: "Soham",lastName: "Patel",emailAddress: "valid@email.com",userName: "spy",password: "12345678")
    void "Expecting to validate as all the conditions for the attributes are verified"() {
        expect:
        p.validate()
    }
    void "Expecting not to validate with empty first name"(){
        when:
        p.firstName = ''
        then:
        !p.validate()
    }
    void "Expecting no to validate as lastname was null"() {
        when:
        p.lastName = ''
        then:
        !p.validate()
    }
    void "Expecting no to validate as username was null"() {
        when:
        p.lastName = ''
        then:
        !p.validate()
    }
    void "Expecting no to validate as email was invalid"() {
        when:
        p.emailAddress = 'thisisnot'
        then:
        !p.validate()
    }

    void "Expecting no to validate as password size is less than 8"() {
        when:
        p.password = 'this'
        then:
        !p.validate()
    }

    void "Expecting no to validate as password size is more than 20"() {
        when:
        p.password = 'thisisnot2322342343234'
        then:
        !p.validate()
    }
}