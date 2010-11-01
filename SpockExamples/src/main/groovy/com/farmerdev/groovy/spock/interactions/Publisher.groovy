package com.farmerdev.groovy.spock.interactions

class Publisher {
	List<Subscriber> subscribers = new LinkedList<Subscriber>()
	void add(Subscriber subscriber){
		subscribers?.add subscriber
	}
	
	void fire(String event){
		for(Subscriber aux:subscribers)
			aux.receive(event);
	}

}
