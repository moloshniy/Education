inline fun <reified T : Any> T.tag(): String {
    return T::class.java.name
}