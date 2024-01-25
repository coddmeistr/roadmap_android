interface Builder {
    fun addSingleCoffee()
    fun addDoubleCoffee()
    fun addMilk()
    fun addCream()
    fun addSugar()
    fun addSyrup()
    fun addCinnamon()
}

class CoffeeBuilder : Builder {
    private var coffee : Coffee = Coffee()

    override fun addSingleCoffee(){
        coffee.coffeeAmount = 1
    }

    override fun addDoubleCoffee(){
        coffee.coffeeAmount = 2
    }

    override fun addMilk(){
        coffee.hasMilk = true
    }

    override fun addSugar(){
        coffee.hasSugar = true
    }

    override fun addSyrup(){
        coffee.hasSyrup = true
    }

    override fun addCinnamon(){
        coffee.hasCinnamon = true
    }

    override fun addCream(){
        coffee.hasCream = true
    }

    fun getResult(): Coffee {
        return coffee
    }
}

class Coffee {
    var coffeeAmount: Int = 0
    var hasMilk: Boolean = false
    var hasCream: Boolean = false
    var hasSugar: Boolean = false
    var hasSyrup: Boolean = false
    var hasCinnamon: Boolean = false

    override fun toString(): String{
        return "amount: $coffeeAmount hasMilk: $hasMilk hasCream: $hasCream hasSugar: $hasSugar hasSyrup: $hasSyrup hasCinnamon: $hasCinnamon"
    }
}