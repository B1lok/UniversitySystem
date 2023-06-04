package lab4web.model;

public class Student {
    public Student(String name, String surname, int gradeBookNumber, int averageGrade) {
        this.name = name;
        this.surname = surname;
        this.gradeBookNumber = gradeBookNumber;
        if (averageGrade < 0 ) this.averageGrade = 0;
        else if (averageGrade > 100) this.averageGrade = 100;
        else this.averageGrade = averageGrade;

    }

    private String name;

    private String surname;

    private int gradeBookNumber;

    private int averageGrade;


    @Override
    public boolean equals(Object obj) {
        Student student = (Student) obj;
        return this.getGradeBookNumber() == student.getGradeBookNumber();
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.getGradeBookNumber();
    }

    public int getGradeBookNumber() {
        return gradeBookNumber;
    }


    public void setGradeBookNumber(int gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
    }


    public int getAverageGrade() {
        return averageGrade;
    }


    public void setAverageGrade(int averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return name + " " + surname + " Average Grade = " + averageGrade + " GradeBookNumber - " + gradeBookNumber;
    }


}
