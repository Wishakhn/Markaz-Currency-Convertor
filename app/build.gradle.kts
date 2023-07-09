plugins {
    id(BuildPluginConfigs.androidApplication)
    kotlin(BuildPluginConfigs.kotlinAndroid)
    id("kotlin-android")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    composeOptions {
        kotlinCompilerExtensionVersion = ComposeVersion.COMPOSE_COMPILER
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
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
    implemGrentKotlinDependencies()
    implementDiDependencies()
    implementComposeDependencies()
    //ksp(ComposeDependencies.COMPOSE_NAV_KSP)
    implementation(LocalStorageDependencies.ANDROID_DATA_STORE)
    implementAndroidXDependencies()
    implementAccompanistDependencies()
    implementKtorAndroidDependencies()
}