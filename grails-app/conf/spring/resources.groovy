package spring


import loginpage.PersonPasswordEncoderListener
import org.springframework.web.servlet.i18n.SessionLocaleResolver

/* Place your Spring DSL code here */
beans = {

    personPasswordEncoderListener(PersonPasswordEncoderListener)
    localeResolver(SessionLocaleResolver) {
        defaultLocale = new Locale('en')
    }
}
