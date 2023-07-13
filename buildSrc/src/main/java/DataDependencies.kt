import org.gradle.api.artifacts.dsl.DependencyHandler

val androidDataDependencies = arrayListOf<String>().apply {
    add(KtorDependencies.KTOR_CLIENT)
    add(KtorDependencies.KTOR_CONTENT_NEGOTIATION)
    add(KtorDependencies.KTOR_SERIALISATION)
    add(KtorDependencies.KTOR_ANDROID_CLIENT)
    add(KtorDependencies.KTOR_LOGGING_CLIENT)
    add(KtorDependencies.KTOR_WEBSOCKETS)
    add(KtorDependencies.KTOR_SERIALIZATION_GSON)
    add(KtorDependencies.KTOR_SERIALISATION_JSON)
    add(KtorDependencies.KTOR_SERIALISATION_KTX)
    add(KtorDependencies.KTOR_JVM)
}

val dataStoreDependencies = arrayListOf<String>().apply {
    add(LocalStorageDependencies.DATA_STORE_OKIO)
    add(LocalStorageDependencies.DATA_STORE)
    add(LocalStorageDependencies.ANDROID_DATA_STORE)
}

val roomDataDependencies = arrayListOf<String>().apply {
    add(RoomDependencies.ROOM_RUNTIME)
    add(RoomDependencies.ROOM_KTX)
}

object KtorDependencies {
    const val KTOR_CLIENT = "io.ktor:ktor-client-cio:${DataVersion.KTOR_CORE}"
    const val KTOR_CONTENT_NEGOTIATION =
        "io.ktor:ktor-client-content-negotiation:${DataVersion.KTOR_CORE}"
    const val KTOR_SERIALISATION = "io.ktor:ktor-client-serialization:${DataVersion.KTOR_CORE}"
    const val KTOR_ANDROID_CLIENT = "io.ktor:ktor-client-android:${DataVersion.KTOR_CLIENT_ANDROID}"
    const val KTOR_LOGGING_CLIENT = "io.ktor:ktor-client-logging:${DataVersion.KTOR_CORE}"
    const val KTOR_WEBSOCKETS =
        "io.ktor:ktor-client-websockets:${DataVersion.KTOR_CORE}"
    const val KTOR_SERIALIZATION_GSON =
        "io.ktor:ktor-serialization-gson:${DataVersion.KTOR_CORE}"
    const val KTOR_SERIALISATION_JSON =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:${DataVersion.KOTLINX_SERIALIZATION_GSON}"
    const val KTOR_SERIALISATION_KTX =
        "io.ktor:ktor-serialization-kotlinx-json:${DataVersion.KTOR_CORE}"
    const val KTOR_JVM = "io.ktor:ktor-client-logging-jvm:${DataVersion.KTOR_CORE}"
}


object LocalStorageDependencies {
    const val DATA_STORE_OKIO = "androidx.datastore:datastore-core-okio:${DataVersion.DTATA_STORE}"
    const val DATA_STORE =
        "androidx.datastore:datastore-preferences-core:${DataVersion.DTATA_STORE}"
    const val ANDROID_DATA_STORE =
        "androidx.datastore:datastore-preferences:${DataVersion.AND_DATA_STORE}"
}

object RoomDependencies {
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${DataVersion.ROOM_VERSION}"
    const val ROOM_KTX = "androidx.room:room-ktx:${DataVersion.ROOM_VERSION}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${DataVersion.ROOM_VERSION}"
}

fun DependencyHandler.implementKtorAndroidDependencies() = implementations(androidDataDependencies)
fun DependencyHandler.implementDataStoreDependencies() = implementations(dataStoreDependencies)
fun DependencyHandler.implementRoomDependencies() = implementations(roomDataDependencies)
