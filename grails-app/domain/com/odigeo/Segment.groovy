package com.odigeo

import java.text.SimpleDateFormat;

class Segment {
	
	String origin
	
	String destiny
	
	String departureDate
	
	String departureTime
	
	String arrivalDate
	
	String arrivalTime
	
	String airline

    static constraints = {
    }
	
	public static Segment generateSegment(List<String> origins, List<String> destinies, 
		List<String> airlines,Date departureDate, Date arrivalDate, Random random){
		
		Segment res = new Segment()
		
		Integer indexOrigin = Math.abs(random.nextInt()) % origins.size()
		
		String origin = origins.get(indexOrigin)
		Integer indexDestiny = Math.abs(random.nextInt()) % destinies.size()
		String destiny = destinies.get(indexDestiny)
		while (origin.equalsIgnoreCase(destiny)){
			indexDestiny = Math.abs(random.nextInt()) % destinies.size()
			destiny = destinies.get(indexDestiny)
		}
		
		
		Integer indexAirlines = Math.abs(random.nextInt()) % airlines.size()
		String airline = airlines.get(indexAirlines)
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String departureDateS = sdf.format(departureDate)
		String arrivalDateS = sdf.format(arrivalDate)
		
		String horaSalida = Segment.normalizeTime(Math.abs(random.nextInt()) % 24 +1)
		String minutoSalida =Segment.normalizeTime(Math.abs( random.nextInt()) % 60 +1)
		
		
		String horaLlegada = Segment.normalizeTime(Math.abs(random.nextInt()) % 24 +1)
		String minutoLlegada =Segment.normalizeTime(Math.abs(random.nextInt()) % 60 +1)
		
		res.origin=origin
		res.destiny=destiny
		res.airline=airline
		res.departureDate=departureDateS
		res.departureTime=horaSalida+":"+minutoSalida
		res.arrivalDate=arrivalDateS
		res.arrivalTime=horaLlegada+":"+minutoLlegada
		
		
		
		return res;
		
	}
		
	public static String normalizeTime(Integer time){
		String res = time.toString()
		if(time<10){
			res=0+res
		}
		return res
	}	
}
