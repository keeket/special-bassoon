package springcourse.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springcourse.petclinic.services.OwnerService;

// prepending context root met /owner
// zie ook bij startup de RequestMappingHandlerMapping om te zien welke urls gebonden zijn
@RequestMapping("/owner")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "index", "index.html"})
    public String ownersList(Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owner/index";
    }
}
