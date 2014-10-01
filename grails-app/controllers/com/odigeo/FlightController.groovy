package com.odigeo

import grails.rest.RestfulController
import grails.converters.JSON
import grails.web.JSONBuilder

class FlightController extends RestfulController {
    static responseFormats = ['json', 'xml']
	
	private static List<String> airports = ["MAD", "BCN", "LON", "PAR"]
	
	private static List<String> airlines = ["IB", "BA", "AF", "FR", "U2"]
	
    FlightController() {
        super(Flight)
    }
	
	def index(Integer max) {
		Random random = new Random()
		List<Flight> flights = new ArrayList<Flight>()
		
		Integer numberFlights = (Math.abs(random.nextInt()) %1500)+800;
		println numberFlights
		for(int i=0;i<numberFlights;i++){
			Date departureDate = new Date()+90
			Date returnDate = new Date()+100
			Segment outBound = Segment.generateSegment(airports, airports, airlines,departureDate,departureDate, random)
			Segment inBound = Segment.generateSegment(airports, airports, airlines,returnDate, returnDate, random)
			inBound.origin=outBound.destiny
			inBound.destiny=outBound.origin
			Money money = Money.generateMoney(random)
			Flight flight = new Flight()
			flight.outBound=outBound
			flight.inBound=inBound
			flight.price=money
			flights.add(flight)
		}
		JSON.use('deep') { render flights as JSON }
		
		
	}
}
