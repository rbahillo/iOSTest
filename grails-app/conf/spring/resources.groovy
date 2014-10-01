// Place your Spring DSL code here
import grails.rest.render.json.*
import com.odigeo.Flight
import com.odigeo.Segment
import com.odigeo.Money
beans = {
	flightRenderer(JsonRenderer, Flight) {
		excludes = ['class', 'id']
	}
	
	segmentRenderer(JsonRenderer, Segment) {
		excludes = ['class', 'id']
		includes = ['origin','destiny','departureDate','departureTime','arrivalDate','arrivalTime','airline']
	}
	
	moneyRenderer(JsonRenderer, Money) {
		excludes = ['class', 'id']
		includes = ['amount','currency']
	}
}
