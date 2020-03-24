package loginpage

import grails.gorm.services.Service

@Service(Authority)
class AuthorityService {

    Authority get(Long id){
        Authority.findById(id)
    }

    List<Authority> list(Map args){

    }

    Long count(){

    }

    void delete(Serializable id){

    }

    Authority save(Authority authority){

    }

}