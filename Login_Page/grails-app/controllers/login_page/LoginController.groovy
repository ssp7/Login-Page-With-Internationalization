package login_page

import grails.plugin.springsecurity.annotation.Secured


@Secured('permitAll')
class LoginController extends grails.plugin.springsecurity.LoginController {

    PersonService personService

    @Override
    def index(){
        if(isLoggedIn()){
            redirect(controller: 'person', action: 'show')
        }
        else{
            redirect(controller: 'person', action: 'LoginPage')
        }
    }
    @Override
    def auth() {

        Person p = personService.login(params.userName, params.password)
        if (p == null) {
            redirect(controller: 'person', action: 'notFound')
        }else {
            if(p.getAuthorities()[0].getAuthority()=="ROLE_SUPERADMIN"){
                redirect(controller:'superAdmin', action: 'superAdminShow', id: p.id)
            }
            else if(p.getAuthorities()[0].getAuthority()=="ROLE_ADMIN"){
                redirect(controller:'admin', action: 'adminShow', id: p.id)
            }
            else if(p.getAuthorities()[0].getAuthority()=="ROLE_USER"){
                redirect(action: 'show', id: p.id)
            }
        }
    }

}
