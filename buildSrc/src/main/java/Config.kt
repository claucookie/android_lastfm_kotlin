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
    object Libs
    object TestLibs
}