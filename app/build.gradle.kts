plugins {
    id(BuildPluginConfigs.androidApplication)
    id(BuildPluginConfigs.jetbrains)
    id(BuildPluginConfigs.ksp)
  //  id("org.jetbrains.kotlin.plugin.serialization")

}

android {
    compileSdk = AppConfiguration.COMPILE_SDK_VERSION
    defaultConfig {
        namespace = AppConfiguration.APPLICATION_ID
        minSdk = AppConfiguration.MIN_SDK_VERSION
        targetSdk = AppConfiguration.TARGET_SDK_VERSION
        versionCode = AppConfiguration.VERSION_CODE
        versionName = AppConfiguration.VERSION_NAME

        testInstrumentationRunner = AppConfiguration.androidTestInstrumentation
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ComposeVersion.COMPOSE_COMPILER
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            excludes += "META-INF/*"
        }
    }
}


dependencies {
    implementAndroidXDependencies()
    implementation(platform(KotlinDependencies.KOTLIN_BOM))
    implementation(ComposeDependencies.COMPOSE_ACTIVITY)
    implementation(platform(ComposeDependencies.COMPOSE_BOM))
    implementation(ComposeDependencies.COMPOSE_MATERIAL)
    implementation(ComposeDependencies.COMPOSE_WINDOW_SIZE)
    ksp(ComposeDependencies.COMPOSE_NAV_KSP)
    //  ksp("androidx.room:room-compiler:2.5.0")
    implementComposeDependencies()
    testDependencies()
    androidTestImplementation(platform(ComposeDependencies.COMPOSE_BOM))
}