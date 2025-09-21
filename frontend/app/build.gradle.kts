plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.apptive.japkor"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.apptive.japkor"
        minSdk = 33
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.navigation.compose) // navigation
    implementation(libs.androidx.credentials) // credentials
    implementation(libs.googleid) // googleId
    implementation(libs.firebase.auth) // firebase auth
    implementation(platform(libs.firebase.bom)) // firebase bom 버전관리 모듈

    implementation("com.google.firebase:firebase-firestore-ktx") // firestore

    implementation("com.squareup.retrofit2:retrofit:2.9.0") // retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // gson converter
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0") // scalars converter
    implementation("com.squareup.okhttp3:okhttp:4.9.3") // okhttp

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
}