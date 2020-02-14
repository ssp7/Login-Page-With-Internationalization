package loginpage

import grails.testing.mixin.integration.Integration
import grails.testing.services.ServiceUnitTest
import org.grails.datastore.mapping.query.Query
import org.springframework.test.annotation.Rollback
import spock.lang.Specification

@Integration
@Rollback
class PersonServiceSpec extends Specification implements ServiceUnitTest<PersonService>{


    void "Expecting list to be 1"() {
       given:
       Person p = new Person(firstName: "Soham",lastName: "Patel",userName: "spykid007", emailAddress: "valid@protonmail.com",password: "12345678")
        when:
        service.save(p)
        then:
        service.list().size() == 1
    }
}
