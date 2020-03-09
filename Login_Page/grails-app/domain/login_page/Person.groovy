package login_page


import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='userName')
@ToString(includes='userName', includeNames=true, includePackage=false)
class Person {
    String firstName
    String lastName
    String emailAddress
    String userName
    String password
    transient confirmPassword

    String toString(){
        firstName + " " + lastName + " " + emailAddress + " "+ userName +  " " + password
    }
    Set<Authority> getAuthorities() {
        (PersonAuthority.findAllByPerson(this) as List<PersonAuthority>)*.authority as Set<Authority>
    }
    static constraints = {
        firstName blank: false
        lastName blank: false
        emailAddress blank: false, email: true, unique: true
        userName blank: false, unique: true
        password blank: false, minSize: 8, maxSize: 20, password: true
        confirmPassword nullable: false, blank: false, password: true, validator: { val, object ->
            if ((val != object.password)) {
                return 'validation.confirmpass'
            }
            return true
        }
    }
}
