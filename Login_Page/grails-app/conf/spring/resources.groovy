package spring
import login_page.PersonPasswordEncoderListener
import org.springframework.web.servlet.i18n.SessionLocaleResolver

/* Place your Spring DSL code here */
beans = {

    personPasswordEncoderListener(PersonPasswordEncoderListener)
    localeResolver(SessionLocaleResolver) {
        defaultLocale = new Locale('en')
    }
}
