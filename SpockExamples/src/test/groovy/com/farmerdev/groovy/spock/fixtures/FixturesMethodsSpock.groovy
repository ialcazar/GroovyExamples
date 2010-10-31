package com.farmerdev.groovy.spock.fixtures

import spock.lang.*;

class FixturesMethodsSpock extends Specification {
	def setup() {System.out.println("setup");}          // run before every feature method
	def cleanup() {System.out.println("cleanup");}        // run after every feature method
	def setupSpec() {System.out.println("setupSpec");}     // run before the first feature method
	def cleanupSpec() {System.out.println("cleanupSpec");}   // run after the last feature method
	
	def "Just one Specification"(){
		expect:
			true == true
	}
	
	def "Just another Specification"(){
		expect:
			false == false
	}
}
