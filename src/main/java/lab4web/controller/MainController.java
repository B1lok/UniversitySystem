package lab4web.controller;


import lab4web.model.Faculty;
import lab4web.model.Institute;
import lab4web.service.InstituteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RequestMapping("/institutes")
@Controller
public class MainController {

    private InstituteService service;

    public MainController(InstituteService service) {
        this.service = service;
    }

    @GetMapping
    public String getMainPage(Model model){


        if (service.getInstitutes() != null) model.addAttribute("institutes", service.getInstitutes());



        return "main";
    }





    @PostMapping
    public String addInstitute(@RequestParam(name = "name")String name, Model model){

        service.addInstitute(new Institute(name));
        model.addAttribute("institutes", service.getInstitutes());
        return "main";
    }

}
