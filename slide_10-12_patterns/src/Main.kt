import Factory.AirDelivery
import Factory.SeaDelivery

fun main() {
    //demoBuilder()
    //demoSingleton()
    //demoFactory()
    demoFacade()
}

fun demoBuilder(){

    val builder = CoffeeBuilder()
    builder.addDoubleCoffee()
    builder.addSyrup()
    val coffee = builder.getResult()
    println(coffee.toString())

}

fun demoSingleton(){
    var obj = Sun.getInstance()
    println(obj)
    obj = Sun.getInstance()
    println(obj)
}

fun demoFactory(){
    val newDelivery = SeaDelivery("type1", "Delivery.by", "USA")
    newDelivery.startDelivery()

    val newDelivery2 = AirDelivery("type2","type1", "Delivery.by", "RUSSIA")
    newDelivery2.startDelivery()
}

fun demoFacade(){
    val manager = UserManager()

    manager.getData("maxim")
    manager.getData("dmitriy")
    manager.getData("maxim")
    manager.getData("alexey")
    manager.getData("dmitriy")
}