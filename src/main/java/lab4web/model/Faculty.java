package lab4web.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Faculty {


    public Faculty(String title) {
        this.title = title;

    }

    public String getTitle() {
        return this.title;
    }

    public Faculty(String title, Institute institute) {
        this.title = title;
        institute.addFaculty(this);
    }

    private String title;

    private int studentAutoId = 0;




    HashMap<Integer, Student> students = new HashMap<>();

    public int getNumOfStudents() {
        return students.size();
    }

    public void addStudent(Student student) {
        students.put(++studentAutoId, student);
    }

    public ArrayList<Student> getStudentsWithExactMark(double mark) {
        ArrayList<Student> studentsWithExactGrade = new ArrayList<>();
        for (Map.Entry<Integer, Student> student : students.entrySet())
            if (student.getValue().getAverageGrade() >= mark) studentsWithExactGrade.add(student.getValue());
        return studentsWithExactGrade;
    }

    public boolean studentWithThisGradeBookExist(int gradeBookNumber){
        for (Map.Entry<Integer, Student> student : students.entrySet())
            if (student.getValue().getGradeBookNumber() == gradeBookNumber) return true;
        return false;
    }


    public Student getStudentByName(String name){
        for (Map.Entry<Integer, Student> student : students.entrySet()){
            if (student.getValue().getName().equals(name)) return student.getValue();
        }
        return null;
    }



    @Override
    public boolean equals(Object obj) {
        Faculty faculty = (Faculty) obj;
        return this.getTitle().equals(faculty.getTitle());
    }

    @Override
    public int hashCode() {
        return this.getTitle().hashCode();
    }



    public HashMap<Integer, Student> getStudents() {
        return students;
    }

    public void setStudents(HashMap<Integer, Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Faculty - " + title + " Number of Students: " + getNumOfStudents();
    }



}
