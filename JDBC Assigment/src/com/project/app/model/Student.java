package com.project.app.model;

public class Student {

    private int    id;
    private String name;
    private int    age;
    private String branch;

    public Student() {}

    public Student(int id, String name, int age, String branch) {
        this.id     = id;
        this.name   = name;
        this.age    = age;
        this.branch = branch;
    }

    public int    getId()     { return id; }
    public String getName()   { return name; }
    public int    getAge()    { return age; }
    public String getBranch() { return branch; }

    public void setId(int id)         { this.id = id; }
    public void setName(String name)   { this.name = name; }
    public void setAge(int age)        { this.age = age; }
    public void setBranch(String b)    { this.branch = b; }

    @Override
    public String toString() {
        return String.format("Student [ID=%-4d | Name=%-20s | Age=%-3d | Branch=%s]",
                id, name, age, branch);
    }
}
