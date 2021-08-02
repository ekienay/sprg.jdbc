package com.def.model;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private int groupId;

    public Student() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return  "id: " + id + " "+
                "firstname: " + firstName + " " +
                "lastname: "+ lastName + " " +
                "groupId: "+ groupId;
    }
}
