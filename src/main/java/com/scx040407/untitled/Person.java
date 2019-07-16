package com.scx040407.untitled;

import java.util.Objects;

public class Person implements Comparable<Person> {
    private int id;
    private String name;

    public Person() {
    }

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }




    @Override
    public int compareTo(Person o) {
        if (this.id > o.id) {
            return this.id - o.id;
        }
        if (this.id < o.id) {
            return this.id - o.id;
        }
        if ((this.name.compareTo(o.name)) > 0) {
            return 1;
        }
        if ((this.name.compareTo(o.name)) < 0) {
            return -1;
        }
        return 0;
    }
}
