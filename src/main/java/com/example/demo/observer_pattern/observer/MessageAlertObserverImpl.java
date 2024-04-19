package com.example.demo.observer_pattern.observer;

import com.example.demo.observer_pattern.observable.StocksObservable;

public class MessageAlertObserverImpl implements NotificationAlertObserver {

	private final StocksObservable stocksObservable;

	private final String email;

	public MessageAlertObserverImpl(StocksObservable stocksObservable, String email) {
		this.stocksObservable = stocksObservable;
		this.email = email;
	}



	@Override
	public void update() {
		System.out.println("Message sent to "+ email +stocksObservable.getStockCount());
		
	}

}
