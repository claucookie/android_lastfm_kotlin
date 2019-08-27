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

    enum class Field(val type: String, val fieldName: String, val value: Any) {
        LastFmApiKey("String", "LAST_FM_API_KEY", "9556cfb87fe52e0f72bdaa3163dda5cf")
    }

    object Libs
    object TestLibs
}