package login_page

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/person/LoginPage")
      // "/"(view: "/layouts/main")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
