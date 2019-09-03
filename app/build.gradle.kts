plugins {
    id(Config.BuildPlugins.androidApplicationPlugin)
    kotlin(Config.BuildPlugins.androidPlugin)
    kotlin(Config.BuildPlugins.kaptPlugin)
    kotlin(Config.BuildPlugins.extensionsPlugin)
}

android {
    compileSdkVersion(Config.Android.compileSdkVersion)
    defaultConfig {
        applicationId = Config.Android.applicationId
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Feature modules
    implementation(project(":search"))
    implementation(project(":core"))

    Config.Modules.app.forEach {
        when(it) {
            is Config.DepConfig.DepImpl -> implementation(it.nameAndVersion)
            is Config.DepConfig.DepKapt -> kapt(it.nameAndVersion)
            is Config.DepConfig.DepTestImpl -> testImplementation(it.nameAndVersion)
            is Config.DepConfig.DepAndroidTestImpl -> androidTestImplementation(it.nameAndVersion)
        }
    }
}
