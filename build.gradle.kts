import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.github.ben-manes.versions") version "0.23.0"
}

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
        // Versions plugin
        classpath("com.github.ben-manes:gradle-versions-plugin:0.23.0")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.register<DependencyUpdatesTask>("checkDependencies") {
    resolutionStrategy {
        componentSelection {
            all {
                // Findout if the latest version is not useful for us
                val rejected = listOf("alpha", "beta", "rc", "cr", "m", "preview", "b", "ea").any { qualifier ->
                    candidate.version.matches(Regex("(?i).*[.-]$qualifier[.\\d-+]*"))
                }
                if (rejected) {
                    reject("We want Release candidates")
                }
            }
        }
    }
    // Optional parameters
    checkForGradleUpdate = true
    outputFormatter = "json"
    outputDir = "build/dependencyUpdates"
    reportfileName = "report"
}

tasks.register<Delete>("clean") {
    val folder = rootProject.buildDir
    delete(folder)
    doLast { print("Deleted ... $folder") }
}
