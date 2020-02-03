package springsec

import com.security.*

class BootStrap {

    def init = { servletContext ->
        def adminRole = Role.findOrSaveWhere(authority: 'ROLE_ADMIN')
        def userRole = Role.findOrSaveWhere(authority: 'ROLE_USER')

        def admin = User.findOrSaveWhere(username: 'ksjoshi88', password: 'kastya', firstname: 'Kaustubh', lastname: 'Joshi', email: 'ksjoshi88@gmail.com')
        def user = User.findOrSaveWhere(username: 'ritesh', password: 'ritu', firstname: 'Ritesh', lastname: 'Bhagat', email: 'ritesh94@gmail.com')

        if (!admin.authorities.contains(adminRole)) {
            UserRole.create(admin, adminRole)
        }

        if (!user.authorities.contains(adminRole)) {
            UserRole.create(user, userRole)
        }
    }
    def destroy = {
    }
}
