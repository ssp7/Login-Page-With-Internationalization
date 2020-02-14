package loginpage

class Person {
    String firstName
    String lastName
    String emailAddress
    String userName
    String password

    String toString(){
        firstName + " " + lastName + " " + emailAddress + " "+ userName +  " " + password
    }
    static constraints = {
        firstName blank: false
        lastName blank: false
        emailAddress blank: false, email: true,unique: true
        userName blank: false, unique: true
        password blank: false, minSize: 8, maxSize: 20
    }
}
