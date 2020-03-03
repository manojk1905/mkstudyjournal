package com.mk.test.designpattern.structural;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecoratorPattern {
    public static void main(String[] args) throws IOException {
        /*
        Decorator pattern allow add new functionality into an existing object
        without altering the structure of existing object.
         */
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        line = br.readLine();
        while(line != null){
            System.out.println(line);
            line = br.readLine();
        }
    }
}
