package com.farmerdev.groovy.spock.features

import java.util.EmptyStackException;

import spock.lang.Specification;

class FeaturesMethodsSpock extends Specification {
//	A feature method consists of 4 phases:
	
//	Set up the feature's fixture (optional)
//	Provide a stimulus to the system under specification
//	Describe the response expected from the system
//	Clean up the feature's fixture (optional)
	
//	Spock has 6 blocks to implement each phase
	
/*
 Blocks				Phases
 --------------------------
 setup		-->		Setup
 when		-->		Stimulus
 then		-->		Response
 expect		-->		Stimulus
 			-->		Response
 cleanup	-->		Cleanup
 where
 */
	
	
	def "Push to a stack an element"(){
		setup: //optional and may be omitted. Variables defined here are shared along when-then blocks.
			def stack = new Stack()
			def elem = "push me"
			//Explicit condition
			// assert stack.empty
//		given: //an alias for setup. Leads to a more readable feature method
		
	//when and then always occur together
	//Multiple when-then blocks are allowed.	
		when: //stimulus
			//Any code
			stack.push(elem)
		
		then: //response
			//Restricted to conditions, expection conditions, interactions and variable definitions.
			!stack.empty
			stack.size() == 1
			stack.peek() == elem
			
		
		
	}
	
	def "Pop from an empty Stack"(){
		setup: 
			def stack = new Stack()
		//Exception Conditions: When block should throw an exception
		when:
			stack.pop()
		then:
			thrown(EmptyStackException)
			stack.empty()
	}
	
	def "HashMap accepts null key"() {
		setup:
		def map = new HashMap()
		
		when:
		map.put(null, "elem")
		
		then:
		notThrown(NullPointerException)
	  }
	
	def "Expect block example"(){
//		An expect block is more limited than a then block in that it may only contain conditions and variable definitions. 
//		It is useful in situations where it is more natural to describe stimulus and expected response in a single expression
		
		//Way 1
		when:
		def x = Math.max(1, 2)
		
		then:
		x == 2
		
		//Way 2: with expect
		expect:
		Math.max(1, 2) == 2
	}
	
	def "Cleanup block example"(){
		setup:
		def file = new File("/some/path")
		file.createNewFile()
		
		
		
		cleanup:
		file?.delete()
	}
	
	//where block
//	A where block always comes last in a method, and may not be repeated. It is used to write data-driven feature methods.
	def "computing the maximum of two numbers"() {
		expect:
		Math.max(a, b) == c
	  
		where:
		a << [5, 3]
		b << [1, 9]
		c << [5, 9]
	  }
	
}
