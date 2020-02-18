package login_page

import grails.gorm.transactions.Transactional
import org.springframework.validation.FieldError
import org.springframework.context.MessageSource
import org.springframework.web.servlet.support.RequestContextUtils as RCU
@Transactional
class PersonService {
    MessageSource messageSource
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
          if(!person.validate()){
              person.errors.allErrors
          }
          else{
          person.validate()
      }
    }
    Person get(String username){
        Person.findByUserName(username)
    }

}
