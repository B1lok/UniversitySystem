package lab4web.model;

import java.util.ArrayList;
import java.util.HashSet;

public class Institute {

    public Institute(String name) {
        this.name = name;
    }

    private String name;

    HashSet<Faculty> faculties = new HashSet<>();


    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }


    public String getName() {
        return name;
    }

    public int numOfFaculties(){
        return faculties.size();
    }



    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Institute) obj).getName());
    }

    public int getNumOfStudents() {
        int numOfStudents = 0;
        for (Faculty faculty : faculties) numOfStudents+= faculty.getNumOfStudents();
        return numOfStudents;
    }

    public HashSet<Faculty> getFaculties() {
        return faculties;
    }

    public ArrayList<Student> getStudentsWithExactGrade(double mark) {
        ArrayList<Student> studentsWithExactMark = new ArrayList<>();
        for (Faculty faculty : faculties)
            studentsWithExactMark.addAll(faculty.getStudentsWithExactMark(mark));
        return studentsWithExactMark;
    }
    public ArrayList<Faculty> getBiggestFaculty() {
        ArrayList<Faculty> biggestFaculties = new ArrayList<>();
        int maxStudents = 0;
        for (Faculty faculty : faculties) {
            if (faculty.getNumOfStudents() > maxStudents) {
                maxStudents = faculty.getNumOfStudents();
                biggestFaculties.clear();
                biggestFaculties.add(faculty);
            } else if (faculty.getNumOfStudents() == maxStudents) biggestFaculties.add(faculty);
        }

        return biggestFaculties;
    }

    @Override
    public String toString() {
        return name;
    }
}
