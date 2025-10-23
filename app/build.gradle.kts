plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.proyecto.project01_a"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.proyecto.project01_a"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // --- DEPENDENCIAS CORE ---
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // --- MANEJO DE VERSIONES: COMPOSE BOM (CRÍTICO) ---
    // Usar el BOM es obligatorio para asegurar que todas las bibliotecas de Compose
    // tengan versiones compatibles. Esto anula las versiones de abajo.
    implementation(platform(libs.androidx.compose.bom))

    // --- DEPENDENCIAS DE COMPOSE (Ahora sin versión, gestionadas por el BOM) ---
    //implementation(libs.androidx.compose.material3) // Ahora gestionada por el BOM
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)

    // Iconos de Material 3 (Estos reemplazan los antiguos material:material-icons-core/extended)
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.ui:ui")

    // --- DEPENDENCIAS ADICIONALES ---
    implementation("androidx.navigation:navigation-compose:2.9.5")
    implementation("io.coil-kt:coil-compose:2.7.0")

    // --- DEPENDENCIAS DE PRUEBA ---
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}
