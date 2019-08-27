plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    defaultConfig {
        minSdkVersion(Config.Android.minSdkVersion)
        targetSdkVersion(Config.Android.targetSdkVersion)
        versionCode = Config.Android.versionCode
        versionName = Config.Android.versionName
        testInstrumentationRunner = Config.Android.instrumentationRunner
        buildConfigField(Config.Field.LastFmApiKey.type, Config.Field.LastFmApiKey.fieldName, "\"${Config.Field.LastFmApiKey.value}\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(project(":core"))
    // Common Android dependencies
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.10")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.1")
    implementation("androidx.recyclerview:recyclerview:1.0.0")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.code.gson:gson:2.8.5")
    // Common Third party libraries
    implementation("com.squareup.retrofit2:retrofit:2.5.0")
    implementation("com.squareup.retrofit2:converter-gson:2.5.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.5.0")
    implementation("com.squareup.okhttp3:okhttp:3.14.0")
    implementation("com.squareup.okhttp3:logging-interceptor:3.14.0")
    implementation("com.google.dagger:dagger:2.21")
    implementation("com.google.dagger:dagger-android:2.21")
    implementation("com.google.dagger:dagger-android-support:2.21")
    kapt("com.google.dagger:dagger-compiler:2.21")
    kapt("com.google.dagger:dagger-android-processor:2.21")
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.7")
    implementation("net.yslibrary.keyboardvisibilityevent:keyboardvisibilityevent:2.2.1@aar")
    // Common Testing libraries
    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
}
