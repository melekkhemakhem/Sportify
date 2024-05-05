plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.sportify"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.sportify"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("com.google.android.gms:play-services-fitness:20.0.0")
    implementation ("com.google.http-client:google-http-client:1.41.1")
    implementation ("com.google.api-client:google-api-client-android:1.31.0")
    implementation ("com.google.http-client:google-http-client-jackson2:1.41.1")



    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.google.api.client:google-api-client-android:latest.version")
    implementation ("com.google.apis:google-api-services-youtube:latest.version")
    implementation("androidx.annotation:annotation-jvm:1.7.1")
    implementation("androidx.wear.watchface:watchface-complications-data:1.2.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}