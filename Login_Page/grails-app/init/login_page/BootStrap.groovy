package login_page

class BootStrap {

    def init = { servletContext ->
        Person p = new Person(firstName: "Soham",lastName: "Patel",emailAddress: "valid@email.com",userName: "spy",password: "12345678").save()
    }
    def destroy = {
    }
}
