plugins {
    id("com.android.application")
    kotlin("android")
}

android {

    namespace = "gun0912.intervaltimepicker.sample"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "gun0912.intervaltimepicker.sample"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

    }

    buildTypes {
        release {
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":intervaltimepicker"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

}
