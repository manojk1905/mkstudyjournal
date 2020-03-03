package com.mk.test.designpattern.structural;

public class AdapterPattern implements Animal{
    private AnimalType animalType ;

    public AdapterPattern(String foodType){
        if(foodType.equalsIgnoreCase("veg")) {
            animalType = new Herbivorous();
        } else  if(foodType.equalsIgnoreCase("non-veg")) {
            animalType = new Carnivorous();
        }
    }

    public static void main(String[] args){
        AdapterPattern adapterPattern = new AdapterPattern("veg");
        adapterPattern.eat("veg","green grass");
        adapterPattern.eat("non-veg","animal meat");
    }

    public void eat(String foodType, String food) {
        if(foodType.equalsIgnoreCase("veg")) {
            animalType.eatVeg(food);
        } else  if(foodType.equalsIgnoreCase("non-veg")) {
            animalType.eatNonVeg(food);
        }
    }
}

interface Animal{
    public void eat(String foodType,String food);
}

interface AnimalType{
    public void eatVeg(String food);
    public void eatNonVeg(String food);
}

class Herbivorous implements AnimalType {

    public void eatVeg(String food) {
        System.out.println("herbivorous");
    }

    public void eatNonVeg(String food) {

    }
}

class Carnivorous implements AnimalType {

    public void eatVeg(String food) {

    }

    public void eatNonVeg(String food) {
        System.out.println("carnivorous");
    }
}
