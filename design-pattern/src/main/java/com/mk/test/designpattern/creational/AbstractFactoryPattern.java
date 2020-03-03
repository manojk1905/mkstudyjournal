package com.mk.test.designpattern.creational;

public class AbstractFactoryPattern {
    public static void main(String[] args){

        AbstractPaintFactory abstractPaintFactory =  FactoryProducer.getFactory(true);
        Color color = abstractPaintFactory.fillPaint("Red");
        System.out.println(color.getColor());
    }
}

abstract class AbstractPaintFactory {
    public abstract Color fillPaint(String color);
}

class RGBPaintFactory extends AbstractPaintFactory {
    public Color fillPaint(String color){
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

class FactoryProducer{

    public static AbstractPaintFactory getFactory(boolean flag){
        if(flag) {
          return new RGBPaintFactory();
        }
        return null;
    }

}

