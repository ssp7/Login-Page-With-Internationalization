package login_page

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.DisabledException
import org.springframework.security.authentication.LockedException

import javax.security.auth.login.AccountExpiredException

@Secured('permitAll')
class LoginController extends grails.plugin.springsecurity.LoginController {

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
        redirect(controller: 'person' , action: 'LoginPage')
    }

}
