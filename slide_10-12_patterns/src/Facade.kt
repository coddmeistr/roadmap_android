class UserManager{
    var api = ApiManager()
    var cache = CacheManager()

    fun getData(key: String): Int{
        println("Working with key: $key")

        var data: Int = 0

        if (!cache.hasInCache(key)){
            data = api.getValueFromApi(key)
            cache.addToCache(key, data)
        } else {
            data = cache.getFromCache(key)
        }

        println("Received value: $data")
        return data
    }
}


class ApiManager{
    val pseudoValues: Array<Int> = arrayOf(1, 1, 5, 6, 5, 1)
    var current = 0

    private fun generatePseudoValue():Int{
        current = if (current == pseudoValues.size) 0 else current
        return pseudoValues[++current]
    }

    fun getValueFromApi(key: String): Int{
        println("Getting value from API")
        return generatePseudoValue()
    }
}

class CacheManager{
    val data: MutableMap<String, Int> = mutableMapOf()

    fun hasInCache(key: String): Boolean{
        return data.containsKey(key)
    }
    fun getFromCache(key: String): Int{
        println("Getting value from cache")
        return data.getValue(key)
    }
    fun addToCache(key: String, value: Int){
        data[key] = value
    }
}