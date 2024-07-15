class Greeting {
    companion object {

        private val platform = getPlatform()
        fun greet(): String {
            return "Hello, ${platform.name}!"
        }
    }
}