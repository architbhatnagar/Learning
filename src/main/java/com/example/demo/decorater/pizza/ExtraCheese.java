package com.example.demo.decorater.pizza;

public class ExtraCheese extends ToppingDecorater{

    BasePizza basePizza;


    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost()+50;
    }
}
