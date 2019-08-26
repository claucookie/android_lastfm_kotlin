// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:3.5.0-rc03")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.10")
        // There is an issue with androidx and dagger 2.20. Beta version solves it
        // https://github.com/google/dagger/issues/1371#issuecomment-449748217
        classpath("com.android.tools.build.jetifier:jetifier-processor:1.0.0-beta02")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register<Delete>("clean") {
    val folder = rootProject.buildDir
    delete(folder)
    doLast { print("Deleted ... $folder") }
}
