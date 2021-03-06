import grails.testing.gorm.DataTest
import grails.testing.services.ServiceUnitTest
import login_page.Person
import login_page.PersonService
import spock.lang.Specification

@SuppressWarnings(['MethodName', 'DuplicateNumberLiteral'])
class PersonServiceSpec extends Specification implements ServiceUnitTest<PersonService>, DataTest {


    def setupSpec() {
        mockDomain Person
    }

    void "Test to find person object"() {
        when: "We save person objects"
        Person.saveAll(
                new Person(firstName: "Soham", lastName: "Patel", emailAddress: "valid@email.com", userName: "spy", password: "12345678"),
                new Person(firstName: "Soham", lastName: "Patel", emailAddress: "valid@email.com", userName: "spy1", password: "12345678")
        )
        then:
        Person.count == 2

        when: "search method is called through service it return the service"
        List<Person> p = service.list()
        then:
        p.size() == 2
        p.get(0).firstName.equalsIgnoreCase("Soham")
        p.get(1).userName.equalsIgnoreCase("spy1")

        when: "we try to validate a person object it should through service"
        Person person = new Person(firstName: "Soham", lastName: "Patel", emailAddress: "valid@email.com", userName: "spy2", password: "12345678")
        then:
        person.validate()
        expect: "we try to save a validated person it should save"
        service.save(person)
        Person.count == 3

        when: "we try to delete a record through service it should work"
        service.delete(person)
        then:
        Person.count == 2
        when: "We try to delete a list of person objects by service then they should be able to be deleted"
        List<Person> listPerson = [Person.get(0),Person.get(1)]
        service.deleteByList(listPerson)
        then:
        Person.count == 1
    }

}