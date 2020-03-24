package loginpage

import org.apache.commons.lang.RandomStringUtils

class BootStrap {

    def init = { servletContext ->
        PersonService personService

        def adminRole = new Authority(authority: "ROLE_ADMIN")
        adminRole.save()
        def userRole = new Authority(authority: "ROLE_USER")
        userRole.save()
        def superRole = new Authority(authority: "ROLE_SUPERADMIN")
        superRole.save()


        Person admin = new Person(firstName: "Soham", lastName: "Patel", emailAddress: "valid@email2.com", username: "spy1", password: "12341234",confirmPassword: "12341234")
        admin.save()
        Person user = new Person(firstName: "Soham", lastName: "Patel", emailAddress: "valid@email3.com", username: "spy", password: "12341234",confirmPassword: "12341234")
        user.save()
        Person superAdmin = new Person(firstName: "Soham", lastName: "Patel", emailAddress: "valid@email.com", username: "spySuper", password: "12341234",confirmPassword: "12341234")
        superAdmin.save()
        PersonAuthority.create(superAdmin,superRole)
        PersonAuthority.create(user,userRole)
        PersonAuthority.create(admin,adminRole)
        int randomStringLength = 10
        String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()
        String firstname
        String lastname
        String username
        String email
        String password
        String confirmPassword
        Random random = new Random()
        Person p
         def domain = ['@gmail.com','@email.com','@talentplus.com','@yahoo.com','@hotmail.com','@fastmail.com','@protonmail.ch','@america.com']
        for(int i = 0; i <30;i++){
         firstname = RandomStringUtils.random(randomStringLength, charset.toCharArray())
         lastname =   RandomStringUtils.random(randomStringLength, charset.toCharArray())
             username =   RandomStringUtils.random(randomStringLength, charset.toCharArray())
            password =   RandomStringUtils.random(randomStringLength, charset.toCharArray())
            email =   RandomStringUtils.random(randomStringLength, charset.toCharArray()) + domain.get(random.nextInt(domain.size()))
            confirmPassword = password
           p =  new Person(firstName: firstname, lastName: lastname, emailAddress: email, username: username, password: password, confirmPassword: confirmPassword)
            p.save()
          PersonAuthority.create(p,userRole)

        }

    }
    def destroy = {
    }
}