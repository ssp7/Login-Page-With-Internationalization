package loginpage

class BootStrap {

    def init = { servletContext ->
        Person person = new Person(
                firstName: "Soham",
                lastName: "Patel",
                userName: "spatel",
                emailAddress: "thisisnot",
                password: "12345678"
        ).save()
    }
    def destroy = {
    }
}
