import org.gradle.api.artifacts.dsl.DependencyHandler

val jetPackComposeDependencies = arrayListOf<String>().apply {
    add(ComposeDependencies.COMPOSE_UI)
    add(ComposeDependencies.COMPOSE_TOOLING_PREVIEW)
    add(ComposeDependencies.COMPOSE_GRAPHICS)
    add(ComposeDependencies.COMPOSE_CONSTRAINT_LAYOUT)
    add(ComposeDependencies.COMPOSE_NAVIGATION)
    add(ComposeDependencies.COMPOSE_VIEW_MODEL)
    add(ComposeDependencies.COMPOSE_DIMENSSIONS)
    add(ComposeDependencies.COMPOSE_SPLASH)
    add(ComposeDependencies.COMPOSE_DESTINATIONS)
    add(ComposeDependencies.COMPOSE_NAV_ANIMATION)
    add(ComposeDependencies.COMPOSE_COIL)
    add(ComposeDependencies.COMPOSE_COIL_GIF)
    add(ComposeDependencies.COMPOSE_CALCULATOR)
    //add(dependencies.ComposeDependencies.COMPOSE_NAV_KSP)
}

object ComposeDependencies {
    //Allows to manage all versions automatically relevent to the BOM version.
    const val COMPOSE_BOM = "androidx.compose:compose-bom:${ComposeVersion.COMPOSE_BOM}"
    const val COMPOSE_ACTIVITY =
        "androidx.activity:activity-compose:${ComposeVersion.COMPOSE_ACTIVITY}"

    const val COMPOSE_UI = "androidx.compose.ui:ui"

    // Tooling support (Previews, etc.)
    const val COMPOSE_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
    const val COMPOSE_GRAPHICS = "androidx.compose.ui:ui-graphics"

    // Material Design 3
    const val COMPOSE_MATERIAL = "androidx.compose.material3:material3:${ComposeVersion.MATERIAL_3}"
    const val COMPOSE_WINDOW_SIZE =
        "androidx.compose.material3:material3-window-size-class:${ComposeVersion.MATERIAL_3}"

    // Integration with observablesComposeDependenciesVersions
    const val COMPOSE_CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout-compose:${ComposeVersion.COMPOSE_CONSTRAINT}"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose"
    const val COMPOSE_VIEW_MODEL =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${ComposeVersion.COMPOSE_VM}"
    const val COMPOSE_SPLASH = "androidx.core:core-splashscreen:${ComposeVersion.COMPOSE_SPLASH}"

    //Compose 3rd Party Depenedencies
    const val COMPOSE_DIMENSSIONS = "com.github.Kaaveh:sdp-compose:${ComposeVersion.COMPOSE_DIMEN}"
    const val COMPOSE_DESTINATIONS =
        "io.github.raamcosta.compose-destinations:core:${ComposeVersion.COMPOSE_DESTINATION}"
    const val COMPOSE_NAV_ANIMATION =
        "io.github.raamcosta.compose-destinations:animations-core:${ComposeVersion.COMPOSE_DESTINATION}"
    const val COMPOSE_NAV_KSP =
        "io.github.raamcosta.compose-destinations:ksp:${ComposeVersion.COMPOSE_DESTINATION}"
    const val COMPOSE_COIL = "io.coil-kt:coil-compose:${ComposeVersion.COIL}"
    const val COMPOSE_COIL_GIF = "io.coil-kt:coil-gif:${ComposeVersion.COIL}"
    const val COMPOSE_CALCULATOR = "com.notkamui.libs:keval:${ComposeVersion.CALCULATOR}"
}

fun DependencyHandler.implementComposeDependencies() = implementations(jetPackComposeDependencies)


