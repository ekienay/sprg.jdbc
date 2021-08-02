package com.def.model;

import java.util.List;

public class Group {

    private int id;
    private String group_name;
    private List<Student> students;

    public Group(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "id: " + id + " " +
                "group_name: " + group_name + " " +
                "students: " + students;
    }
}
