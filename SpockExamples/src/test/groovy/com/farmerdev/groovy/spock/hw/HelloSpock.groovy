package com.farmerdev.groovy.spock.hw

class HelloSpock extends spock.lang.Specification {
	//Spock test structure:
	
	// fields
	// fixture methods
	// feature methods
	// helper methods
	
	
	//a feature method
	def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }
} 
