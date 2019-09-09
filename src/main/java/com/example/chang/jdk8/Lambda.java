package com.example.chang.jdk8;

import org.junit.jupiter.api.Test;

public class Lambda {
    public  String c="1";
    @Test
    public void test1(){
        c ="2";
        Print p = (a) ->{return c+"2";};
        System.out.println((p.print(9)));
        System.out.println(c);
    }

}

interface Print{
    String print(int a);
}
