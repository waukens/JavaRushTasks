package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();

    private int age;
    private String name;


    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student student : students) {
            if (averageGrade == student.getAverageGrade()) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student studentWithMaxAverageGrade;
        if (students.size() > 0) {
            studentWithMaxAverageGrade = students.get(0);
        } else {
            return null;
        }

        for (Student student : students) {
            if (studentWithMaxAverageGrade.getAverageGrade() < student.getAverageGrade()) {
                studentWithMaxAverageGrade = student;
            }
        }
        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        Student studentWithMaxAverageGrade;
        if (students.size() > 0) {
            studentWithMaxAverageGrade = students.get(0);
        } else {
            return null;
        }

        for (Student student : students) {
            if (studentWithMaxAverageGrade.getAverageGrade() > student.getAverageGrade()) {
                studentWithMaxAverageGrade = student;
            }
        }
        return studentWithMaxAverageGrade;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}