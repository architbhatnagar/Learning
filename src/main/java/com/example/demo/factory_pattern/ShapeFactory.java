package com.example.demo.factory_pattern;

public class ShapeFactory {

    public Shape getSphape(String input){
        switch (input){
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            default:
                return null;
        }
    }
}
