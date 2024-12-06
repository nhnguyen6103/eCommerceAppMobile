//plugins {
//    alias(libs.plugins.android.application)
//    alias(libs.plugins.kotlin.android)
//}
//
//android {
//    namespace = "com.example.ecommerceappmobile"
//    compileSdk = 34
//
//    defaultConfig {
//        applicationId = "com.example.ecommerceappmobile"
//        minSdk = 24
//        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
//    }
//    kotlinOptions {
//        jvmTarget = "17"
//    }
//
//    buildFeatures{
//        viewBinding=true
//    }
//}
//
//dependencies {
//
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    implementation(libs.androidx.activity)
//    implementation(libs.androidx.constraintlayout)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//
//
//    //lifecycle
//    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-runtime:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-livedata:2.6.2")
//
//
//    //ViewModel
//    implementation("androidx.activity:activity-ktx:1.4.0")
//
//    implementation("com.github.bumptech.glide:glide:4.12.0")
//    implementation("com.google.code.gson:gson:2.9.1")
//    implementation("com.tbuonomo:dotsindicator:5.0")
//}

//plugins {
//    alias(libs.plugins.android.application)
//    alias(libs.plugins.kotlin.android)
//    alias(libs.plugins.google.gms.google.services)
//}
//
//android {
//    namespace = "com.example.ecommerceappmobile"
//    compileSdk = 34
//
//    defaultConfig {
//        applicationId = "com.example.ecommerceappmobile"
//        minSdk = 24
//        targetSdk = 34
//        versionCode = 1
//        versionName = "1.0"
//
//        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//    }
//
//    buildTypes {
//        release {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }
//
//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_17
//        targetCompatibility = JavaVersion.VERSION_17
//    }
//
//    kotlinOptions {
//        jvmTarget = "17"
//    }
//
//    buildFeatures {
//        viewBinding = true
//    }
//}
//
//dependencies {
//    // BOM cho Firebase
//    implementation (platform("com.google.firebase:firebase-bom:32.2.2"))
//
//    // Firebase Realtime Database
//    implementation ("com.google.firebase:firebase-database-ktx")
//
//    // AndroidX Libraries
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
//    implementation(libs.material)
//    implementation(libs.androidx.activity)
//    implementation(libs.androidx.constraintlayout)
//
//    // Lifecycle Libraries (đã tối ưu, không sử dụng lifecycle-extensions lỗi thời)
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
//    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
//
//    // Glide for Image Loading
//    implementation("com.github.bumptech.glide:glide:4.12.0")
//
//    // Gson for JSON Parsing
//    implementation("com.google.code.gson:gson:2.9.1")
//
//    // Dots Indicator
//    implementation("com.tbuonomo:dotsindicator:5.0")
//    implementation(libs.firebase.database)
//
//    // Unit Testing
//    testImplementation(libs.junit)
//
//    // Android Instrumented Testing
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//}
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.ecommerceappmobile"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ecommerceappmobile"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // BOM cho Firebase
    implementation (platform("com.google.firebase:firebase-bom:32.2.2"))

    // Firebase Realtime Database - chọn một trong hai
    implementation("com.google.firebase:firebase-database-ktx") // Với KTX
    // implementation("com.google.firebase:firebase-database") // Nếu không dùng KTX

    // AndroidX Libraries
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Lifecycle Libraries
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    // Glide for Image Loading
//    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")

    // Gson for JSON Parsing
    implementation("com.google.code.gson:gson:2.9.1")

    // Dots Indicator
    implementation("com.tbuonomo:dotsindicator:5.0")

    //Picasso
    implementation ("com.squareup.picasso:picasso:2.8")
    // Unit Testing
    testImplementation(libs.junit)

    // Android Instrumented Testing
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


}
