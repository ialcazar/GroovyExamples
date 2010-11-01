package com.farmerdev.groovy.closures

import spock.lang.Specification;
//http://groovy.codehaus.org/Closures
class ClosuresExamples extends Specification {
	def "Closure simple example"(){
		def clos = { println "hello!" }
		
		println "Executing the Closure:"
		clos()
	}
	
	def "Closure example"(){
		def printSum = { a, b -> print a+b }
		printSum( 5, 7 )                       //prints "12"
	}
}
