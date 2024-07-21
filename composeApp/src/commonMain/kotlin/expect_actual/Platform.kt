package expect_actual

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform