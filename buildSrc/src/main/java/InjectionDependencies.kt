import org.gradle.api.artifacts.dsl.DependencyHandler

val androidDiDependencies = arrayListOf<String>().apply {
    add(DiDependencies.KOIN)
    add(DiDependencies.KOIN_COMPOSE)
    add(DiDependencies.KOIN_ANDROID_COMPAT)
    add(DiDependencies.KOIN_NAVIGATION)
}
object DiDependencies {
    const val KOIN = "io.insert-koin:koin-android:${KoinVersion.KOIN_ANDROID}"
    const val KOIN_COMPOSE = "io.insert-koin:koin-androidx-compose:${KoinVersion.KOIN_COMPOSE}"
    const val KOIN_ANDROID_COMPAT = "io.insert-koin:koin-android-compat:${KoinVersion.KOIN_ANDROID}"
    const val KOIN_CORE = "io.insert-koin:koin-core:${KoinVersion.KOIN}"
    const val KOIN_NAVIGATION = "io.insert-koin:koin-androidx-navigation:${KoinVersion.KOIN_ANDROID}"
}

fun DependencyHandler.implementDiDependencies() = implementations(androidDiDependencies)
