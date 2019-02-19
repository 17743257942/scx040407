package com.scx040407.untitled.practice3.test;

import java.util.Objects;

public class Student {
    private String name;
    private String birth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(birth, student.birth);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, birth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public static void main(String[] args) {
        System.out.println(new Student() == new Student());
        System.out.println(new Student().equals(new Student()));
        System.out.println(new Student().hashCode());
    }
}
