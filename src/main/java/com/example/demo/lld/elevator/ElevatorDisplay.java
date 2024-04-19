package com.example.demo.lld.elevator;

public class ElevatorDisplay {

    private int floor;

    private Direction direction;

    public void setDisplay(int floor,Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public void getDisplay(){
        System.out.println(this.floor);
        System.out.println(this.direction.name());
    }
}
