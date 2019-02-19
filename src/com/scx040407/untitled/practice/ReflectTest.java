package com.scx040407.untitled.practice;

import java.lang.reflect.Constructor;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Class<Student> clazz = Student.class;
        Student student = new Student();
        Class clazz2 = student.getClass();
        Class clazz3 = Class.forName("com.scx040407.untitled.practice.Student");

        System.out.println(clazz.getName());
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors
             ) {
            System.out.println(c.isVarArgs());
        }

        Constructor constructor = clazz.getDeclaredConstructor(int.class, String.class);
        Class[] classes = constructor.getParameterTypes();
        for (Class c : classes
             ) {
            System.out.println("parameter type:"+c.getName());
        }

        Class[] classes2 = constructor.getExceptionTypes();
        for (Class c : classes2
                ) {
            System.out.println("exception's type："+c.getName());
        }


    }

}
