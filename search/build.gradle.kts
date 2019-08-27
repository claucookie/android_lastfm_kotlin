plugins {
    id(Config.BuildPlugins.androidLibrary)
    kotlin(Config.BuildPlugins.android)
    kotlin(Config.BuildPlugins.kapt)
    kotlin(Config.BuildPlugins.extensions)
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
