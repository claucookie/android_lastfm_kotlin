plugins {
    id(Config.BuildPlugins.androidLibraryPlugin)
    kotlin(Config.BuildPlugins.androidPlugin)
    kotlin(Config.BuildPlugins.kaptPlugin)
    kotlin(Config.BuildPlugins.extensionsPlugin)
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
    Config.Modules.core.forEach {
        when(it) {
            is Config.DepConfig.DepImpl -> implementation(it.nameAndVersion)
            is Config.DepConfig.DepKapt -> kapt(it.nameAndVersion)
            is Config.DepConfig.DepTestImpl -> testImplementation(it.nameAndVersion)
            is Config.DepConfig.DepAndroidTestImpl -> androidTestImplementation(it.nameAndVersion)
        }
    }
}
