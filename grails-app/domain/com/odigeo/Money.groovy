package com.odigeo

class Money {
	
	Double amount
	
	String currency
	
	public static List<String> currencies=["USD","EUR","GBP","JPY"]

    static constraints = {
    }
	
	public static Money generateMoney(Random random){
		
		Double random2 = (random.nextDouble() *1000)+50;
		Money res = new Money()
		res.setAmount(random2)
		
		Integer indexCurrency = Math.abs(random.nextInt()) % currencies.size()
		res.currency=currencies.get(indexCurrency)
		
		return res
	}
}
