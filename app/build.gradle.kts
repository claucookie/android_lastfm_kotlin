plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "dev.claucookielabs.lastfm"
        minSdkVersion(22)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
}

dependencies {
    // Feature modules
    implementation(project(":search"))
    implementation(project(":core"))
    // Common Android dependencies
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.10")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.1")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("androidx.fragment:fragment-ktx:1.0.0")
    // Common Third party libraries
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.google.dagger:dagger:2.21")
    implementation("com.google.dagger:dagger-android:2.21")
    implementation("com.google.dagger:dagger-android-support:2.21")
    kapt("com.google.dagger:dagger-compiler:2.21")
    kapt("com.google.dagger:dagger-android-processor:2.21")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.7")
    // Common Testing libraries
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
}