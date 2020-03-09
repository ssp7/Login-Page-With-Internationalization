package login_page

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AuthorityServiceSpec extends Specification {

    AuthorityService authorityService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Authority(...).save(flush: true, failOnError: true)
        //new Authority(...).save(flush: true, failOnError: true)
        //Authority authority = new Authority(...).save(flush: true, failOnError: true)
        //new Authority(...).save(flush: true, failOnError: true)
        //new Authority(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //authority.id
    }

    void "test get"() {
        setupData()

        expect:
        authorityService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Authority> authorityList = authorityService.list(max: 2, offset: 2)

        then:
        authorityList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        authorityService.count() == 5
    }

    void "test delete"() {
        Long authorityId = setupData()

        expect:
        authorityService.count() == 5

        when:
        authorityService.delete(authorityId)
        sessionFactory.currentSession.flush()

        then:
        authorityService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Authority authority = new Authority()
        authorityService.save(authority)

        then:
        authority.id != null
    }
}
