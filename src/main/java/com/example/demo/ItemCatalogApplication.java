package com.example.demo;

import com.example.demo.decorater.pizza.BasePizza;
import com.example.demo.decorater.pizza.ExtraCheese;
import com.example.demo.decorater.pizza.Margherita;
import com.example.demo.factory_pattern.Shape;
import com.example.demo.factory_pattern.ShapeFactory;
import com.example.demo.observer_pattern.observable.IphoneObservableImpl;
import com.example.demo.observer_pattern.observable.StocksObservable;
import com.example.demo.observer_pattern.observer.MessageAlertObserverImpl;
import com.example.demo.observer_pattern.observer.NotificationAlertObserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ItemCatalogApplication {

	public static void main(String[] args) {
		//observerPattern
		//SpringApplication.run(ItemCatalogApplication.class, args);
		//decoraterPattern();
		factoryPattern();
	}

	static void decoraterPattern(){
		BasePizza basePizza=new ExtraCheese(new ExtraCheese(new Margherita()));
		System.out.println("Cost of pizza :-"+basePizza.cost());
	}

	static void factoryPattern(){
		ShapeFactory shapeFactory=new ShapeFactory();
		Shape shape= shapeFactory.getSphape("RECTANGLE");
		shape.draw();
	}




	void observerPattern(){
		StocksObservable stocksObservable=new IphoneObservableImpl();
		NotificationAlertObserver notificationAlertObserver=new MessageAlertObserverImpl(stocksObservable,"archit");
		stocksObservable.add(notificationAlertObserver);
		stocksObservable.setStockCount(10);
		stocksObservable.setStockCount(0);
		stocksObservable.setStockCount(100);
	}

}
