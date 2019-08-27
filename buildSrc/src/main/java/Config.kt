object Config {
    object BuildPlugins 

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
        val impl = listOf(
            "androidx.recyclerview:recyclerview:1.0.0",
            "net.yslibrary.keyboardvisibilityevent:keyboardvisibilityevent:2.2.1@aar",
            "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.3.10",
            "androidx.appcompat:appcompat:1.0.2",
            "androidx.core:core-ktx:1.0.1",
            "androidx.constraintlayout:constraintlayout:1.1.3",
            "androidx.fragment:fragment-ktx:1.0.0",
            "com.squareup.retrofit2:retrofit:2.5.0",
            "com.squareup.retrofit2:converter-gson:2.5.0",
            "com.squareup.retrofit2:adapter-rxjava2:2.5.0",
            "com.squareup.okhttp3:okhttp:3.14.0",
            "com.squareup.okhttp3:logging-interceptor:3.14.0",
            "com.google.dagger:dagger:2.21",
            "com.google.dagger:dagger-android:2.21",
            "com.google.dagger:dagger-android-support:2.21",
            "io.reactivex.rxjava2:rxandroid:2.1.1",
            "io.reactivex.rxjava2:rxjava:2.2.7",
            "com.google.code.gson:gson:2.8.5",
            "com.github.bumptech.glide:glide:4.9.0"
        )
        val kapt = listOf(
            "com.google.dagger:dagger-compiler:2.21",
            "com.google.dagger:dagger-android-processor:2.21",
            "com.github.bumptech.glide:compiler:4.9.0"
        )
        val testImpl = listOf(
            "junit:junit:4.12",
            "com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0"
        )
        val androidTestImpl = listOf(
            "androidx.test:runner:1.1.1",
            "androidx.test.espresso:espresso-core:3.1.1"
        )
    }

    enum class Field(val type: String, val fieldName: String, val value: Any) {
        LastFmApiKey("String", "LAST_FM_API_KEY", "9556cfb87fe52e0f72bdaa3163dda5cf")
    }
}