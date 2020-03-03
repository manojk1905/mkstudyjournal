package com.mk.test.designpattern.creational;

import ch.qos.logback.core.net.SyslogOutputStream;

public class FactoryPattern {

    public static void main(String[] args){
        FactoryPattern factoryPattern = new FactoryPattern();
        Color colorObj = factoryPattern.getColor("red");
        System.out.println(colorObj.getColor());
    }

    public Color getColor(String color){
        Color colorObj = null;
        if(color.equalsIgnoreCase("Red")){
            colorObj = new Red();
        } else if(color.equalsIgnoreCase("Green")){
            colorObj = new Green();
        } else if(color.equalsIgnoreCase("Blue")){
            colorObj = new Blue();
        }
        return colorObj;
    }
}


interface Color{
    public String getColor();
}

class Red implements Color {

    public String getColor() {
        return "Red";
    }
}
class Green implements Color {

    public String getColor() {
        return "Green";
    }
}
class Blue implements Color {

    public String getColor() {
        return "Blue";
    }
}