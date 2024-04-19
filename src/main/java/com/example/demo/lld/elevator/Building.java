package com.example.demo.lld.elevator;

import java.util.List;

public class Building {

    List<Floor> floorList;

    public Building(List<Floor> floorList) {
        this.floorList = floorList;
    }

    public void addFloor(Floor floor){
        this.floorList.add(floor);
    }

    public void removeFloor(Floor floor){
        floorList.remove(floor);
    }

    List<Floor> getAllFloorList(){
        return floorList;
    }
}
