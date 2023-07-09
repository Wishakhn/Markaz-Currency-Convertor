
val implementClassPaths = arrayListOf<String>().apply {
    add(BuildConfigurations.KOTLIN_GRADLE_PLUGIN)
    add(BuildConfigurations.KOTLIN_SERIALISATION)
    add(BuildConfigurations.JUNIT_5)
}

object BuildConfigurations {
    const val KOTLIN_GRADLE_PLUGIN =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersion.KOTLIN}"
    const val KOTLIN_SERIALISATION =
        "org.jetbrains.kotlin:kotlin-serialization:${PluginVersion.SERIALISATION}"
    const val JUNIT_5 =
        "de.mannodermaus.gradle.plugins:android-junit5:${PluginVersion.JUNIT_5_GRADLE}"
}




