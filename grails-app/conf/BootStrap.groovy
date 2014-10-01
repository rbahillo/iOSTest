import com.odigeo.Flight
import com.odigeo.Segment
import com.odigeo.Money

class BootStrap {

    def init = { servletContext ->
		
		grails.converters.JSON.registerObjectMarshaller(Flight) {
			return it.properties.findAll {k,v -> k != 'class' && k!='id'}
		}
		grails.converters.JSON.registerObjectMarshaller(Segment) {
			return it.properties.findAll {k,v -> k != 'class' && k!='id'}
		}
		grails.converters.JSON.registerObjectMarshaller(Money) {
			return it.properties.findAll {k,v -> k != 'class' && k!='id'}
		}
		
    }
    def destroy = {
    }
}
