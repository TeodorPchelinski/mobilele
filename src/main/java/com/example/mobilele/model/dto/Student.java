package com.example.mobilele.model.dto;

public class Student {

    private String name;

    private int age;

    private String uni;

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Student setAge(int age) {
        this.age = age;
        return this;
    }

    public String getUni() {
        return uni;
    }

    public Student setUni(String uni) {
        this.uni = uni;
        return this;
    }
}
