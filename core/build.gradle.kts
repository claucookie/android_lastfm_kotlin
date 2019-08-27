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

}

dependencies {
    Config.Libs.impl.forEach {
        implementation(it)
    }
    Config.Libs.kapt.forEach {
        kapt(it)
    }
    Config.Libs.testImpl.forEach {
        testImplementation(it)
    }
    Config.Libs.androidTestImpl.forEach {
        androidTestImplementation(it)
    }
}
