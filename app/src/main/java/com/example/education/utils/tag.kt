inline fun <reified T : Any> T.tag(): String {
    return "qqq" + T::class.java.name
}