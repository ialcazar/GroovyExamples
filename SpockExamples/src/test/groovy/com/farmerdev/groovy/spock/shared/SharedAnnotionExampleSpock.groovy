package com.farmerdev.groovy.spock.shared

import spock.lang.*;

class SharedAnnotionExampleSpock extends Specification {
	@Shared myPerson = new Person()
	
	def "@Shared variables should be shared among all the methods of the Spec"(){
		myPerson.name="Juan"
		System.out.println("1-->"+myPerson)
		expect: 
			myPerson.name == "Juan"
	}
	def "@Shared variables should be shared among all the methods of the Spec2"(){
		
		System.out.println("2-->"+myPerson)
		expect:
			myPerson.name == "Juan"
	}
}
