package login_page

import grails.gorm.transactions.Transactional

@Transactional
class PersonService {

    void save(Person person) {
       person.save()
    }
    void delete(Person person){
        person.delete()
    }
    List<Person> list(){
        Person.list()
    }

    void deleteByList(List<Person> listOfPerson){
       Person.deleteAll(listOfPerson)
    }
    void validate(Person person){
        person.validate()
    }
}
