package Factory

abstract class Transport(company: String, weight: Float, volume: Float) {
    var company: String
    var maxWeight: Float
    var maxVolume: Float

    init {
        this.company = company
        maxWeight = weight
        maxVolume = volume
    }

    abstract fun deliver(destination: String)
}

class Ship(company: String, weight: Float, volume: Float) : Transport(company, weight, volume) {

    override fun deliver(destination: String) {
        println("Delivered via ship by $company. To $destination. Max weight: $maxWeight. Max volume: $maxVolume")
    }
}

class Airplane(company: String, weight: Float, volume: Float) : Transport(company, weight, volume) {

    override fun deliver(destination: String) {
        println("Delivered via airplane by $company. To $destination. Max weight: $maxWeight. Max volume: $maxVolume")
    }
}

class Train(company: String, weight: Float, volume: Float) : Transport(company, weight, volume) {

    override fun deliver(destination: String) {
        println("Delivered via train by $company. To $destination. Max weight: $maxWeight. Max volume: $maxVolume")
    }
}

class Car(company: String, weight: Float, volume: Float) : Transport(company, weight, volume) {

    override fun deliver(destination: String) {
        println("Delivered via car by $company. To $destination. Max weight: $maxWeight. Max volume: $maxVolume")
    }
}