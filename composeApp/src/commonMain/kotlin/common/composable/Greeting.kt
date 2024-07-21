package common.composable

import expect_actual.getPlatform

class Greeting {
    companion object {

        private val platform = getPlatform()
        fun greet(): String {
            return "Hello, ${platform.name}!"
        }
    }
}