package com;

import org.w3c.dom.ls.LSOutput;

public class fanshe {
    public static void main(String[] args) throws Exception {
        ClassLoader loader=fanshe.class.getClassLoader();
        Class s=Class.forName("com.Cat",false,loader);
        /*
        Class c=loader.loadClass("com.Cat");
        c.newInstance();*/
    }

}
class Cat{
    static {
        System.out.println("cat");
    }
}