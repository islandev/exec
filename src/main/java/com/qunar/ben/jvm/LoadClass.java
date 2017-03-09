package com.qunar.ben.jvm;

/**
 * Created by ben on 2017/3/8.
 */
public class LoadClass {
}
class B extends Object
{
    static
    {
        System.out.println("Load B");
    }
    public B()
    {
        System.out.println("Create B");
    }
}
class A extends B
{
    static
    {
        System.out.println("Load A");
    }
    public A()
    {
        System.out.println("Create A");
    }
}

 class Testclass
{
    public static void main(String[] args)
    {
        new A();
    }
}
