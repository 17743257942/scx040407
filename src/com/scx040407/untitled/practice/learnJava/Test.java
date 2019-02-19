package com.scx040407.untitled.practice.learnJava;

import com.scx040407.untitled.Person;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
//        somTest();
//        useWhile();
//        useDecimalFormat();
//        countMulty();
//        intArray0();
//        intArrays();
//        intArrays2();
//        sortPersonById();
//        sortPersonByName();
//        binarySearchTest();
//        bubbleSort();
//        selectSort();
//        reverseSort();
//        changeShican();
        return;
    }

    private static void changeShican() {
        Pig pig = new Pig();
        pig.id = 333;
        changePig(pig);
    }

    private static void changePig(Pig pig) {
        pig.id = 1; // 如果形参是指针类型的变量，那么方法里面操作的是形参本身，可以做出改变。
        System.out.println(pig);
    }


    private static void reverseSort() {
        int[] array = {63,4,24,1,3,15};
        Arrays.sort(array);
        int times = array.length / 2;
        for (int i = 0; i < times; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        for (int x : array) {
            System.out.print(x+" ");
        }
    }
    private static void selectSort() {
        int[] array = {63,4,24,1,3,15};
        for (int i = 1; i < array.length; i++) {
            int index = 0;
            for (int j = 1; j <= array.length - i;j++) {
                if (array[j] > array[index]) {
                    index = j;
                }
            }
            int temp = array[array.length - i];
            array[array.length - i] = array[index];
            array[index] = temp;
        }
        for (int x : array) {
            System.out.print(x+" ");
        }
    }

    private static void bubbleSort() {
        int[] array = {63,4,24,1,3,15};
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i;j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        for (int x : array) {
            System.out.print(x+" ");
        }
    }

    private static void binarySearchTest() {
        int arr[] = new int[]{4,25,10,9,80,7,-8,-2 };
        Arrays.sort(arr);
        System.out.println("排序后的数组是：");
        for (int a:arr) {
            System.out.print(a+" ");
        }
        System.out.println();
        int index = binarySearch0(arr,0,5,8);
        //插入点是第一个大于8的数的索引，没有找到返回相反数即负的此索引
        System.out.println("当数字为8时的插入点："+index);
        int index2 = binarySearch0(arr,0,5,9);
        System.out.println("当数字为9时的插入点："+index2);
    }
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    private static void sortPersonByName() {
        List<Person> personList = new ArrayList<>();
        for (int i=0;i<100;i++){
            Person p = new Person(0,String.valueOf(new Random().nextInt(1000)));
            personList.add(p);
        }
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if ((o1.getName().compareTo(o2.getName())) > 0) {
                    return 1;
                }
                if ((o1.getName().compareTo(o2.getName())) < 0) {
                    return -1;
                }
                return 0;
            }
        });
        for (Person p : personList) {
            System.out.println(p);
        }
    }

    private static void sortPersonById() {
        List<Person> personList = new ArrayList<>();
        for (int i=0;i<100;i++){
            Person p = new Person(new Random().nextInt(1000));
            personList.add(p);
        }
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() > o2.getId()) {
                    return o1.getId() - o2.getId();
                }
                if (o1.getId() < o2.getId()) {
                    return o1.getId() - o2.getId();
                }
                return 0;
            }
        });
        for (Person p : personList) {
            System.out.println(p);
        }
    }

    private static void intArray0() {
        int[] aaa;
        aaa = new int[5] ;
        aaa[0] = 2;
        System.out.println(aaa[0]+" "+aaa[1]);

        int arr[] = new int[]{1,2,3,4,5};
        int arr2[] = {11,22,33};
    }

    private static void useDecimalFormat() {
        DecimalFormat df = new DecimalFormat("###############,####,####,####.##kg");
        String sss = df.format(11122.677676); //1,1122.68kg
        df = new DecimalFormat("\u2030");
        sss = df.format(2.324);    //‰2324
        df = new DecimalFormat("\u00A4");
        sss = df.format(2.324);    //￥2
        System.out.println(sss);
    }

    private static void useWhile() {
        /**
         * 需求：使用while循环计算 1 + 1/2! + 1/3! + 1/4! + ...1/20!
         * 乍一看好像挺简单，但是要注意时间复杂度！控制在O(n)
         * 结果要准确，还是有点难度的！
         */
        int ii = 2; //计数因子
        double sum = 1.0; //总和
        long multiplication = 1; //分母阶乘结果
        long t1 = System.currentTimeMillis();
        while (ii < 21) {
            multiplication *= ii;
            sum += 1.0/multiplication;
            System.out.println(multiplication);
            ii++ ;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis()-t1);
    }

    private static void somTest() {
        int a = 0x22;
        int b = 0123;
        System.out.println(a);
        System.out.println(b);

        char c = 'a';
        System.out.println(c);
        char d = 655;
        System.out.println(d);
        int e = 20332;
        System.out.println((char)e);

        String f = "\22";
        String g = "\u2605";
        String h = "aa\rdd";
        String i = "aaa\naaa";

        System.out.println(2&3);
        System.out.println(8|8);

        System.out.println(1<<3);
        System.out.println(-1>>1);
        System.out.println(-1>>>1);
        char j = 10;
        byte l = 100;
        System.out.println(l*j); //自动转化为char双字节


        String str = "scx";
        switch (str) {
            case "sc" :
                System.out.println("sssssss"+str);
                break;
            case "scx":
            {
                System.out.println("sdfadf");
                break;
            }
            default:
                System.out.println("default");
        }
    }

    private static void intArrays2() {
        Person p1 = new Person(1,"aaa");
        Person p2 = new Person(1, "aaac");
        Person p3 = new Person(2, "aaa");
        Person[] pp = new Person[]{p1,p2,p3};
        Arrays.sort(pp);
        for (Person ppp : pp) {
            System.out.println(ppp);
        }
    }

    private static void intArrays() {
        int arr3[][] = new int[10][];
        for (int i2 = 0; i2 < 10; i2++) {
            int j22[] = new int[10];
            for (int j2 = 0; j2 < 10; j2++) {
                j22[j2] = j2;
            }
            arr3[i2]=j22;
        }
        for (int kk=0;kk<10;kk++){
            for (int mm=0;mm<10;mm++) {
                System.out.print(arr3[kk][mm]);
            }
            System.out.println();
        }
    }

    private static void countMulty() {
        BigDecimal ii2 = new BigDecimal("2"); //计数因子
        BigDecimal sum2 = new BigDecimal("1"); //总和
        BigDecimal multiplication2 = new BigDecimal("1"); //分母阶乘结果
        long t12 = System.currentTimeMillis();
        while (!ii2.subtract(new BigDecimal("55")).equals(new BigDecimal(0))) {
            multiplication2=multiplication2.multiply(ii2) ;
            sum2 = sum2.add(new BigDecimal("1").divide(multiplication2, 200, RoundingMode.HALF_UP ));
            System.out.println(multiplication2);
            ii2=ii2.add(new BigDecimal("1")) ;
        }
        System.out.println(sum2);
        System.out.println(System.currentTimeMillis()-t12);
    }



}
