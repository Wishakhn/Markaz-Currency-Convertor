// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
        maven ( "https://jitpack.io")
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