package loginpage

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here

            }
        }

          "/"(view: "/login/index")
      // "/"(view: "/layouts/main")
        "500"(view:'/person/error')
        "404"(view:'/person/notFound')
    }
}
