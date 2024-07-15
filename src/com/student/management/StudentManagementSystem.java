package com.student.management;

import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int id, String name, String course, String session, String rollNo) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setCourse(course);
                student.setSession(session);
                student.setRollNo(rollNo);
                break;
            }
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student getStudentByRollNo(String rollNo) {
        for (Student student : students) {
            if (student.getRollNo().equals(rollNo)) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
