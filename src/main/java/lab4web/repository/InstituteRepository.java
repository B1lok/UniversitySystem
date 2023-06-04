package lab4web.repository;


import lab4web.model.Faculty;
import lab4web.model.Institute;
import lab4web.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;

@Repository
public class InstituteRepository {



    private HashSet<Institute> institutes = new HashSet<>();


    public void addInstitute(Institute institute){
        institutes.add(institute);
    }

    public HashSet<Institute> getInstitutes() {
        return institutes;
    }

    public Institute getByName(String name){
        for (Institute inst : institutes){
            if (inst.getName().equals(name)) return inst;
        }
        return null;
    }

    public Faculty getFaculty(Institute institute, String title){
        for (Faculty faculty : institute.getFaculties()){
            if (faculty.getTitle().equals(title)) return faculty;
        }
        return null;
    }






}
