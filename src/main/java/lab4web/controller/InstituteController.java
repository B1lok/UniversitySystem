package lab4web.controller;


import lab4web.model.Faculty;
import lab4web.model.Institute;
import lab4web.service.InstituteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/institutes/{name}")
@SessionAttributes("institute")
public class InstituteController {

    InstituteService service;


    public InstituteController(InstituteService service) {
        this.service = service;
    }

    @GetMapping
    public String institutePage(@PathVariable String name, Model model){
        if (service.getInstituteByName(name) != null) {
            Institute institute = service.getInstituteByName(name);
            model.addAttribute("institute", institute);
            model.addAttribute("faculties", institute.getFaculties());
        }
        return "institute";
    }

    @PostMapping
    public String addFaculty(@ModelAttribute Institute institute,@RequestParam(name = "title") String title, Model model){
        institute.addFaculty(new Faculty(title));
        model.addAttribute("faculties", institute.getFaculties());
        return "institute";
    }


    @PostMapping("/students")
    public String getStudentsWithExactMark(Model model, @SessionAttribute Institute institute, @RequestParam int grade){

        model.addAttribute("students", institute.getStudentsWithExactGrade(grade));

        return "students";
    }


    @PostMapping("/largest-faculty")
    public String getBiggestFaculty(Model model, @SessionAttribute Institute institute){
        model.addAttribute("biggestFaculties", institute.getBiggestFaculty());
        model.addAttribute("faculties", institute.getFaculties());
        return "institute";
    }


}
