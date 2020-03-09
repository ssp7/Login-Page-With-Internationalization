package login_page

import grails.gorm.services.Service

@Service(Authority)
interface AuthorityService {

    Authority get(Serializable id)

    List<Authority> list(Map args)

    Long count()

    void delete(Serializable id)

    Authority save(Authority authority)

}