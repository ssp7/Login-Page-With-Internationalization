package login_page

import grails.gorm.transactions.Transactional
import org.springframework.context.MessageSource

@Transactional
class PersonService {
    MessageSource messageSource

    void save(Person person) {
        person.save()
    }

    void delete(Person person) {
        person.delete()
    }

    List<Person> list() {
        Person.list()
    }

    void create(params) {
        new Person(params).save()
    }

    void deleteByList(List<Person> listOfPerson) {
        Person.deleteAll(listOfPerson)
    }

    void validate(Person person) {
        if (!person.validate()) {
            person.errors.allErrors
        } else {
            person.validate()
        }
    }

    Person get(String username) {
        Person.findByUserName(username)
    }

    def get(Person person) {
        person
    }

    Person login(String username, String password) {
        Person.findByUserNameAndPassword(username, password)
    }
    def count(){
        Person.count
    }
}
