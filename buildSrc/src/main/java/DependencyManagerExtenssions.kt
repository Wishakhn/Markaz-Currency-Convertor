
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.initialization.dsl.ScriptHandler

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("dependencies.kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("dependencies.implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("dependencies.androidTestImplementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(dependency: String) {
    add("dependencies.androidTestImplementation", dependency)
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("dependencies.testImplementation", dependency)
    }
}

fun DependencyHandler.jetpackImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("jetPackComposeImplementation", dependency)
    }
}

fun DependencyHandler.classpath(list: List<String>) {
    list.forEach { classPath ->
        this.add(ScriptHandler.CLASSPATH_CONFIGURATION, classPath)
    }
}

fun DependencyHandler.testImplementation(dependency: String) {
    add("dependencies.testImplementation", dependency)
}

fun DependencyHandler.testRuntimeOnly(dependency: String) {
    add("dependencies.testRuntimeOnly", dependency)
}

/**
 * Adds a dependency to the `dependencies.debugImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("dependencies.debugImplementation", dependencyNotation)

/**
 * Adds a dependency to the `dependencies.implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("dependencies.implementation", dependencyNotation)

/**
 * Adds a dependency to the `dependencies.api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */

fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("dependencies.api", dependencyNotation)

/**
 * Adds a dependency to the `dependencies.kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("dependencies.kapt", dependencyNotation)
