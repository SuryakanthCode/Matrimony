plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.hilt.android)
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.matrimonysampleapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.matrimonysampleapp"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            pickFirsts += "**"
        }
    }
}



dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //RecyclerView
    implementation(libs.androidx.recyclerview)
    // For control over item selection of both touch and mouse driven selection
    implementation(libs.androidx.recyclerview.selection)

    //Support library
    implementation(libs.androidx.appcompat)
    // For loading and tinting drawables on older versions of the platform
    implementation(libs.androidx.appcompat.resources)

    //Room
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)

    //Glide
    implementation(libs.glide.runtime)
    implementation(libs.glide.runtime)

    //constraint layout
    implementation(libs.androidx.constraintlayout)

    //Navigation
    // Jetpack Compose integration
    implementation(libs.androidx.navigation.compose)
    // Views/Fragments integration
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)
    // Feature module support for Fragments
    implementation(libs.androidx.navigation.dynamic.features.fragment)
    // Testing Navigation
    androidTestImplementation(libs.androidx.navigation.testing)

    //gson
    implementation(libs.gson)

    //Hilt
    implementation(libs.hilt)
    implementation(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.google.hilt.android.compiler)

    //SystemUi
    implementation(libs.system.ui)

    //Coil
    implementation(libs.coil.compose)

    //cardStack
    implementation(libs.lazycardstack.android)

    implementation("com.alexstyl.swipeablecard:swipeablecard:0.1.0")

}

