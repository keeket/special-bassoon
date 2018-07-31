package springcourse.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// prepending context root met /owner
// zie ook bij startup de RequestMappingHandlerMapping om te zien welke urls gebonden zijn
@RequestMapping("/owner")
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String ownersList() {
        return "owner/index";
    }
}
