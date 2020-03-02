package login_page

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import grails.testing.spock.OnceBefore
import org.apache.tools.ant.taskdefs.condition.Http
import spock.lang.Shared
import spock.lang.Specification
import sun.net.www.http.HttpClient

@SuppressWarnings(['JUnitPublicNonTestMethod', 'JUnitPublicProperty'])
@Integration
@Rollback
class PersonControllerIntSpec extends Specification {
    @Shared HttpClient client

    PersonService personService

    @OnceBefore
    void init() {
        String baseUrl = "http://localhost:$serverPort"
        this.client = HT
    }
}
