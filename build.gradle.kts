// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(BuildPluginConfigs.ksp) version "1.8.20-1.0.10" apply false
    //id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
}
buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        implementClassPaths.forEach { classPaths ->
            classpath(classPaths)
        }
    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
