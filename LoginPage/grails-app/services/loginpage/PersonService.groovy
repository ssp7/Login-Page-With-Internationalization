package loginpage

import grails.gorm.transactions.Transactional

@Transactional
class PersonService {

    def save(Person person) {
       person.save()
    }
    def delete(long id){
        Person.findById(id).delete()
    }
    List<Person> list(){
        Person.list()
    }
    Person getPersonById(long id){
        Person.findById(id)
    }
    Person deleteByList(List<Long> id){

    }
}
