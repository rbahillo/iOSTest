package com.odigeo



class KeepAliveJob {
    static triggers = {
		cron name: 'keepAlive', cronExpression: "59 * * * * ?"
		//simple name: 'mySimpleTrigger', startDelay: 10000, repeatInterval: 100000
	}

    def execute() {
       def url = "http://odigeo-iostest.herokuapp.com/flight"
 
		new URL(url).withReader ("UTF-8") {
			print "Accesing heroku app" 
		}
    }
}
