object Config {
    object BuildPlugins {
        val androidApplication = "com.android.application"
        val androidLibrary = "com.android.library"
        val android = "android"
        val kapt = "kapt"
        val extensions = "android.extensions"
    }

    object Android {
        val minSdkVersion = 22
        val targetSdkVersion = 28
        val compileSdkVersion = 28
        val applicationId = "dev.claucookielabs.lastfm"
        val versionCode = 1
        val versionName = "1.0"
        val instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    object Libs {
        val kotlin = listOf(
            Config.DepConfig.DepImpl("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.10")
        )
        val androidX = listOf(
            Config.DepConfig.DepImpl("androidx.recyclerview:recyclerview:1.0.0"),
            Config.DepConfig.DepImpl("androidx.appcompat:appcompat:1.0.2"),
            Config.DepConfig.DepImpl("androidx.core:core-ktx:1.0.1"),
            Config.DepConfig.DepImpl("androidx.constraintlayout:constraintlayout:1.1.3"),
            Config.DepConfig.DepImpl("androidx.fragment:fragment-ktx:1.0.0")
        )
        val retrofit = listOf(
            Config.DepConfig.DepImpl("com.squareup.retrofit2:retrofit:2.5.0"),
            Config.DepConfig.DepImpl("com.squareup.retrofit2:converter-gson:2.5.0"),
            Config.DepConfig.DepImpl("com.squareup.retrofit2:adapter-rxjava2:2.5.0"),
            Config.DepConfig.DepImpl("com.squareup.okhttp3:okhttp:3.14.0"),
            Config.DepConfig.DepImpl("com.squareup.okhttp3:logging-interceptor:3.14.0")
        )
        val dagger = listOf(
            Config.DepConfig.DepImpl("com.google.dagger:dagger:2.21"),
            Config.DepConfig.DepImpl("com.google.dagger:dagger-android:2.21"),
            Config.DepConfig.DepImpl("com.google.dagger:dagger-android-support:2.21"),
            Config.DepConfig.DepKapt("com.google.dagger:dagger-compiler:2.21"),
            Config.DepConfig.DepKapt("com.google.dagger:dagger-android-processor:2.21")
        )
        val rxJava = listOf(
            Config.DepConfig.DepImpl("io.reactivex.rxjava2:rxandroid:2.1.1"),
            Config.DepConfig.DepImpl("io.reactivex.rxjava2:rxjava:2.2.7"),
            Config.DepConfig.DepImpl("com.google.code.gson:gson:2.8.5")
        )
        val unitUiTest = listOf(
            Config.DepConfig.DepTestImpl("junit:junit:4.12"),
            Config.DepConfig.DepTestImpl("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"),
            Config.DepConfig.DepAndroidTestImpl("androidx.test:runner:1.1.1"),
            Config.DepConfig.DepAndroidTestImpl("androidx.test.espresso:espresso-core:3.1.1")
        )
        val utils = listOf(
            Config.DepConfig.DepImpl("com.github.bumptech.glide:glide:4.9.0"),
            Config.DepConfig.DepKapt("com.github.bumptech.glide:compiler:4.9.0"),
            Config.DepConfig.DepImpl("net.yslibrary.keyboardvisibilityevent:keyboardvisibilityevent:2.2.1@aar")
        )

        val dependencies = kotlin + androidX + retrofit + dagger + rxJava + unitUiTest + utils
    }

    sealed class DepConfig(open var nameAndVersion: String) {
        data class DepImpl(override var nameAndVersion: String) : DepConfig(nameAndVersion)
        data class DepKapt(override var nameAndVersion: String) : DepConfig(nameAndVersion)
        data class DepTestImpl(override var nameAndVersion: String) : DepConfig(nameAndVersion)
        data class DepAndroidTestImpl(override var nameAndVersion: String) : DepConfig(nameAndVersion)
    }

    enum class Field(val type: String, val fieldName: String, val value: Any) {
        LastFmApiKey("String", "LAST_FM_API_KEY", "9556cfb87fe52e0f72bdaa3163dda5cf")
    }
}