class Sun private constructor() {

    companion object {

        @Volatile private var instance: Sun? = null

        fun getInstance() =
            instance ?: synchronized(this) { // synchronized to avoid concurrency problem
                instance ?: Sun().also { instance = it }
            }
    }
}