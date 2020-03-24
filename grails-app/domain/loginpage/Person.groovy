package loginpage

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class Person implements Serializable {
    String firstName
    String lastName
    String emailAddress
    String username
    String password
    String confirmPassword

    String toString() {
        firstName + " " + lastName + " " + emailAddress + " " + username + " " + password
    }

    Set<Authority> getAuthorities() {
        (PersonAuthority.findAllByPerson(this) as List<PersonAuthority>)*.authority as Set<Authority>
    }
    static constraints = {
        firstName blank: false
        lastName blank: false
        emailAddress blank: false, email: true, unique: true
        username blank: false, unique: true
        password blank: false, password: true
        confirmPassword nullable: false, blank: false, password: true, validator: { val, obj ->
            if ((val != obj.password)) {
                return 'validation.confirmpass'
            }
            return true
        }
    }
    static mapping = {
        password column: '`password`'
    }
}
