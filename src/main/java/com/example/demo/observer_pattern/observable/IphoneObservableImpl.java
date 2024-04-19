package com.example.demo.observer_pattern.observable;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.observer_pattern.observer.NotificationAlertObserver;

public class IphoneObservableImpl implements StocksObservable{

	private List<NotificationAlertObserver> notificationAlertObservers = new ArrayList<>();
	private Integer stockCount =0 ;

	@Override
	public void add(NotificationAlertObserver notificationAlertObserver) {
		notificationAlertObservers.add(notificationAlertObserver);
		
	}

	@Override
	public void remove(NotificationAlertObserver notificationAlertObserver) {
		notificationAlertObservers.remove(notificationAlertObserver);
		
	}

	@Override
	public Integer getStockCount() {
		return stockCount;
	}

	@Override
	public void setStockCount(Integer stockCount) {
		if(stockCount==0) {
			notifyObserver();
		}
		this.stockCount+=stockCount;
		
	}

	@Override
	public void notifyObserver() {
		for(var notification : notificationAlertObservers) {
			notification.update();
		}
		
	}
	
	

}
