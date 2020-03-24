package loginpage


import org.springframework.security.access.annotation.Secured

@Secured('permitAll')
class LoginController extends grails.plugin.springsecurity.LoginController {


    @Override
    def index() {
        if(isLoggedIn()){
            redirect uri: conf.successHandler.defaultTargetUrl
        }
        else {
            render(view: '/login/index')
        }
    }
    @Override
    def auth() {
        if (isLoggedIn()) {
            redirect(controller: 'person', action: 'LoginPage')
        } else {
            redirect(controller: 'login', action: 'index')
        }
    }
}
