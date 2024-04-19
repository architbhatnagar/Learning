package com.example.demo.observer_pattern.observable;

import com.example.demo.observer_pattern.observer.NotificationAlertObserver;

public interface StocksObservable {
	
	public void add(NotificationAlertObserver notificationAlertObserver);
	
	public void remove(NotificationAlertObserver notificationAlertObserver);
	
	public Integer getStockCount();
	
	public void setStockCount(Integer stockCount);
	
	public void notifyObserver();

}
