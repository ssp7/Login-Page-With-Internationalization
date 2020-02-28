package login_page

import org.apache.commons.lang.RandomStringUtils

class BootStrap {

    def init = { servletContext ->
        int randomStringLength = 10
        String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()
        String firstname
        String lastname
        String username
        String email
        String password
        Random random = new Random()
        Person p
         def domain = ['@gmail.com','@email.com','@talentplus.com','@yahoo.com','@hotmail.com','@fastmail.com','@protonmail.ch','@america.com']
        for(int i = 0; i <50;i++){
         firstname = RandomStringUtils.random(randomStringLength, charset.toCharArray())
         lastname =   RandomStringUtils.random(randomStringLength, charset.toCharArray())
             username =   RandomStringUtils.random(randomStringLength, charset.toCharArray())
            password =   RandomStringUtils.random(randomStringLength, charset.toCharArray())
            email =   RandomStringUtils.random(randomStringLength, charset.toCharArray()) + domain.get(random.nextInt(domain.size()))
           p = new Person(firstName: firstname, lastName: lastname, emailAddress: email, userName: username, password: password, confirmPassword: password).save()

        }
        Person legit = new Person(firstName: "Soham", lastName: "Patel", emailAddress: "valid@email.com", userName: "spy", password: "12345678", confirmPassword: "12345678").save()
    }
    def destroy = {
    }
}
