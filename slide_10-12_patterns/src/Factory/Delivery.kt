package Factory

abstract class Delivery(var company: String, country: String) {
    var destination: String = country
    var usingTransport: Transport? = null

    abstract fun createTransport(): Transport
    abstract fun startDelivery()
}

class SeaDelivery(var waterType: String, company: String, country: String) : Delivery(company, country){

    override fun startDelivery() {
        usingTransport = createTransport()
        usingTransport!!.deliver(destination)
        println("Started sea delivery with water type: $waterType")
    }
    override fun createTransport(): Transport {
        return Ship(company, 100000.0f, 1000000.0f)
    }
}

class AirDelivery(var flightType: String, var planeType: String, company: String, country: String) : Delivery(company, country){

    override fun startDelivery() {
        usingTransport = createTransport()
        usingTransport!!.deliver(destination)
        println("Started air delivery with flight type: $flightType and plane type: $planeType")
    }
    override fun createTransport(): Transport {
        return Airplane(company, 100000.0f, 1000000.0f)
    }
}

class RailwayDelivery(var railwaySize: Float, var hasBallast: Boolean, company: String, country: String) : Delivery(company, country){

    override fun startDelivery() {
        usingTransport = createTransport()
        usingTransport!!.deliver(destination)
        println("Started railway delivery with railway size: $railwaySize and with ballast: $hasBallast")
    }
    override fun createTransport(): Transport {
        return Train(company, 100000.0f, 1000000.0f)
    }
}

class CarDelivery(company: String, country: String) : Delivery(company, country){

    override fun startDelivery() {
        usingTransport = createTransport()
        usingTransport!!.deliver(destination)
        println("Started car delivery")
    }
    override fun createTransport(): Transport {
        return Car(company, 100.0f, 1000.0f)
    }
}