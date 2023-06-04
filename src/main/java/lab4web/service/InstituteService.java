package lab4web.service;


import lab4web.model.Faculty;
import lab4web.model.Institute;
import lab4web.model.Student;
import lab4web.repository.InstituteRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class InstituteService {


    InstituteRepository repository;

    public InstituteService(InstituteRepository repository) {
        this.repository = repository;
    }


    public void addInstitute(Institute institute){
        repository.addInstitute(institute);
    }


    public Institute getInstituteByName(String name){
        return repository.getByName(name);
    }

    public Faculty getFaculty(Institute institute, String title){
        return repository.getFaculty(institute, title);
    }


    public HashSet<Institute> getInstitutes() {
        return repository.getInstitutes();
    }








}
