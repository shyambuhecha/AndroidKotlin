package com.example.javademo;

public class Demo {
    int a;
    {System.out.println("init");}
    public static void main(String[] args) {
        Demo d = new Demo();
        d.a = 100;
        System.out.println(d.a);

    }
}
