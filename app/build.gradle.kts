plugins {
    id("com.android.application")
}

android {
    compileSdk = 33
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "org.asteroidos.sync"
        minSdk = 24
        targetSdk = 33
        versionCode = 28
        versionName = "0.28"
    }
    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    sourceSets {
        named("main") {
            java {
                srcDir("src/main/lib/android-ripple-background/library/src/main/java/")
                srcDir("src/main/lib/material-intro-screen/material-intro-screen/src/main/java/")
                srcDir("src/main/lib/powerampapi/poweramp_api_lib/src/")
            }
            res {
                srcDir("src/main/lib/android-ripple-background/library/src/main/res/")
                srcDir("src/main/lib/material-intro-screen/material-intro-screen/src/main/res/")
                srcDir("src/main/lib/powerampapi/poweramp_api_lib/res/")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    lint {
        checkReleaseBuilds = true
        disable += "MissingTranslation"
    }
    namespace = "org.asteroidos.sync"
}

repositories {
    mavenCentral()
    maven("https://maven.google.com")
    maven("https://jitpack.io")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    testImplementation("junit:junit:4.13.2")
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("com.google.android.material:material:1.8.0")
    implementation("com.github.MagneFire:EasyWeather:1.3")
    implementation("com.google.code.gson:gson:2.9.1")
    implementation("org.osmdroid:osmdroid-android:6.1.14")
    implementation("no.nordicsemi.android.support.v18:scanner:1.6.0")
    implementation("no.nordicsemi.android:ble:2.6.0")
}
