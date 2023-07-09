import org.gradle.api.artifacts.dsl.DependencyHandler

object TestlDependencies {
    const val KOIN_TEST_JUNIT5 = "io.insert-koin:koin-test-junit5:${KoinVersion.KOIN}"
    const val KOIN_TEST = "io.insert-koin:koin-test:${KoinVersion.KOIN}"
    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestVersion.COROUTINES}"
    const val JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:${TestVersion.JUNIT5}"
    const val JUPITER_PARAM = "org.junit.jupiter:junit-jupiter-params:${TestVersion.JUNIT5}"
    const val JUPITER = "org.junit.jupiter:junit-jupiter-api:${TestVersion.JUNIT5}"
    const val JUNIT_COMPOSE = "androidx.compose.ui:ui-test-junit4:${TestVersion.JUNIT4_COMPOSE}"
    const val JUNIT_X = "androidx.test.ext:junit:${TestVersion.ANDROID_X_JUNIT}"
    const val ESSPRESSO = "androidx.test.espresso:espresso-core:${TestVersion.ESSPRESSO}"
    const val COMPOSE_UI_DEBUG = "androidx.compose.ui:ui-tooling"
    const val COMPOSE_UI_MANIFEST = "androidx.compose.ui:ui-test-manifest"
}

fun DependencyHandler.testDependencies() {
    testImplementation(TestlDependencies.COROUTINES)
    testImplementation(TestlDependencies.JUPITER)
    testImplementation(TestlDependencies.JUPITER_PARAM)
    androidTestImplementation(TestlDependencies.JUNIT_X)
    androidTestImplementation(TestlDependencies.ESSPRESSO)
    androidTestImplementation(TestlDependencies.JUNIT_COMPOSE)
    debugImplementation(TestlDependencies.COMPOSE_UI_DEBUG)
    debugImplementation(TestlDependencies.COMPOSE_UI_MANIFEST)
    testRuntimeOnly(TestlDependencies.JUPITER_ENGINE)
}

