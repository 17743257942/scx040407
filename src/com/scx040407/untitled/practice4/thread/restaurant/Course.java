package com.scx040407.untitled.practice4.thread.restaurant;

/**
 * 2018/07/27 ÏÂÎç 11:16
 */
public enum Course {
    APPETIER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        Food food = Enums.random(values);
        return food;
    }

    public static void main(String[] args) {
        for (Course c : Course.values()) {
            System.out.println(c);
            System.out.println("-----------------------------");
            for (Food f : c.values) {
                System.out.println(f);
            }
            System.out.println("==============================");
        }
    }

}
