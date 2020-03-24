package loginpage

import grails.gorm.transactions.Transactional
import org.springframework.context.MessageSource

@Transactional
class PersonService {
    MessageSource messageSource

    void save(Person person) {
        person.save()
    }

    void delete(Person person) {
        PersonAuthority.remove(person,person.getAuthorities()[0])
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
        Person.findByUsername(username)
    }

    def get(Person person) {
        person
    }

    def login(String username, String confirmPassword) {
        Person.findByUsernameAndConfirmPassword(username, confirmPassword)
    }
    def count(){
        Person.count
    }


}
