package lab4web.controller;


import lab4web.model.Faculty;
import lab4web.model.Institute;
import lab4web.model.Student;
import lab4web.service.InstituteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/institutes/{name}/{facultyName}")
@Controller
@SessionAttributes({"faculty", "tempStudent"})
public class FacultyController {


    InstituteService service;

    public FacultyController(InstituteService service) {
        this.service = service;
    }

    @GetMapping
    public String facultyPage(@PathVariable String facultyName,@SessionAttribute Institute institute, Model model){


        if (service.getFaculty(institute, facultyName) != null){
        Faculty faculty = service.getFaculty(institute, facultyName);
        model.addAttribute("institute", institute);
        model.addAttribute("faculty", faculty);
        model.addAttribute("students", faculty.getStudents());
        }


        return "faculty";
    }

    @GetMapping("/addStudent")
    public String addStudentPage(){
        return "addStudent";
    }


    @PostMapping("/addStudent")
    public String addStudent(Model model, @SessionAttribute Faculty faculty,@SessionAttribute Institute institute,
                             @RequestParam String name,
                             @RequestParam String surname,
                             @RequestParam int gradeBookNumber,
                             @RequestParam int averageGrade){
        if (faculty.studentWithThisGradeBookExist(gradeBookNumber)){
            model.addAttribute("warning", "Student with this gradeBookNumber already exist");
            return "addStudent";
        }
        faculty.addStudent(new Student(name, surname, gradeBookNumber, averageGrade));
        model.addAttribute("institute", institute);
        model.addAttribute("faculty", faculty);
        model.addAttribute("students", faculty.getStudents());


        return "faculty";
    }


    @GetMapping("/{student}")
    public String updateStudentGet(@PathVariable String student, @SessionAttribute Faculty faculty, Model model){
        Student tempStudent = faculty.getStudentByName(student);
        model.addAttribute("tempStudent", tempStudent);
        return "updateStudent";
    }

    @PostMapping("/{student}")
    public String updateStudentPost(Model model, @SessionAttribute Student tempStudent,@SessionAttribute Faculty faculty,@SessionAttribute Institute institute,
                                    @RequestParam String name,
                                    @RequestParam String surname,
                                    @RequestParam int gradeBookNumber,
                                    @RequestParam int averageGrade){
        model.addAttribute("tempStudent", tempStudent);
        if (faculty.studentWithThisGradeBookExist(gradeBookNumber) && gradeBookNumber != tempStudent.getGradeBookNumber()){
            model.addAttribute("updateWarning", "Student with this gradeBookNumber already exist");
            return "updateStudent";
        }

        tempStudent.setName(name);
        tempStudent.setSurname(surname);
        tempStudent.setGradeBookNumber(gradeBookNumber);
        tempStudent.setAverageGrade(averageGrade);

        model.addAttribute("institute", institute);
        model.addAttribute("faculty", faculty);
        model.addAttribute("students", faculty.getStudents());

        return "faculty";
    }






}
