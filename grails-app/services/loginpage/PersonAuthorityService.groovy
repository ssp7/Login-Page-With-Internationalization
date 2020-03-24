package loginpage

import grails.gorm.transactions.Transactional

@Transactional
class PersonAuthorityService {

    def create(Person person, Authority authority) {
     PersonAuthority.create(person,authority)
    }
}
