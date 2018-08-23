package springcourse.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springcourse.petclinic.services.VetService;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vet", "vet/", "vet/index", "vet/index.html"})
    public String vetList(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vet/index";
    }
}
