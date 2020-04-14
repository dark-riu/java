package com;

import java.lang.reflect.Field;

public class IE {
    public static void main(String[] args) throws Exception {
        Student stu1 = new Student("张三", 23, 1984367, "男", "中国");
        Student stu2 = new Student("王舞", 18, 23648, "女", "中国");
        Class c = Student.class;
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!field.get(stu1).equals(field.get(stu2))) {
                System.out.println(field.getName() + "不同：" + "stu1的值是：" + (field.get(stu1) + "") + "," + "stu2的值是" + (field.get(stu2) + ""));
            }
        }
    }
}

class Student {
    private String name;
    private int age;
    private int no;
    private String sex;
    private String country;

    public Student(String name, int age, int no, String sex, String country) {
        this.name = name;
        this.age = age;
        this.no = no;
        this.sex = sex;
        this.country = country;
    }
}


