import com.android.build.api.dsl.Packaging

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.bedir.chatdemo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bedir.chatdemo"
        minSdk = 31
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        exclude("META-INF/proguard/androidx-annotations.pro")
        exclude("META-INF/gradle/incremental.annotation.processors")
        exclude("META-INF/LICENSE")
        exclude ("META-INF/*.properties")
        exclude ("META-INF/AL2.0")
        exclude ("META-INF/LGPL2.1")
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }



}

dependencies {
    val lifecycle = "2.6.2"
    val  nav = "2.7.4"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(project(mapOf("path" to ":usecase")))
    implementation(project(mapOf("path" to ":room")))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.dagger:hilt-android:2.44.2")
    implementation ("com.google.dagger:hilt-android-compiler:2.37")
    implementation ("androidx.navigation:navigation-fragment-ktx:$nav")
    implementation ("androidx.navigation:navigation-ui-ktx:$nav")
    implementation ("androidx.navigation:navigation-fragment-ktx:$nav")
    implementation ("androidx.navigation:navigation-ui-ktx:$nav")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle")
    implementation ("androidx.lifecycle:lifecycle-process:$lifecycle")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("com.google.code.gson:gson:2.10.1")
    implementation ("androidx.core:core-splashscreen:1.0.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

}