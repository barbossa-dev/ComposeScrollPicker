
plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    id("maven-publish")
}

android {
    namespace = "ir.barbossa.composescrollpicker"
    compileSdk = 34
    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
    buildFeatures{
        compose=true
    }
}
publishing {
    publications {
        create("release", MavenPublication::class) {
            groupId = "com.github.barbossa-dev"
            artifactId = "ComposeScrollPicker"
            version = "1.0.8"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.runtime.android)
    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.foundation.android)
    implementation(libs.androidx.material3.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
