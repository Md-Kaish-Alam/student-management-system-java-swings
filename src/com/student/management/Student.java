package com.student.management;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String course;
    private String session;
    private String rollNo;
    private Map<Integer, Integer> semesterMarks;

    public Student(String name, String course, String session, String rollNo) {
        this.id = idCounter++;
        this.name = name;
        this.course = course;
        this.session = session;
        this.rollNo = rollNo;
        this.semesterMarks = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getSession() {
        return session;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public void addSemesterMarks(int semester, int marks) {
        this.semesterMarks.put(semester, marks);
    }

    public Map<Integer, Integer> getSemesterMarks() {
        return semesterMarks;
    }

    public int getTotalMarks() {
        return semesterMarks.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", course=" + course + ", session=" + session + ", rollNo=" + rollNo + ", semesterMarks=" + semesterMarks + "]";
    }
}
