package one.volod.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform