@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.vanniktech.mavenPublish)
}

kotlin {
    compilerOptions {
        freeCompilerArgs.apply {
            add("-Xwarning-level=NOTHING_TO_INLINE:disabled")
            add("-Xwarning-level=UNCHECKED_CAST:disabled")
        }
    }
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_9)
        }
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    watchosX64()
    watchosArm64()
    watchosSimulatorArm64()

    tvosX64()
    tvosArm64()
    tvosSimulatorArm64()

    applyDefaultHierarchyTemplate()

    js {
        browser()
        nodejs()
    }

    wasmJs {
        browser()
        nodejs()
        d8()
    }
    wasmWasi {
        nodejs()
    }


    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":bits"))
            }
        }
        val platformIndependentMain by creating {
            dependsOn(commonMain.get())
        }

        val webSources = listOf(jsMain, wasmJsMain, wasmWasiMain)

        webSources.forEach {
            it { dependsOn(platformIndependentMain) }
        }
    }
}

android {
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = 33 // byteArrayViewVarHandle support
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_9
        targetCompatibility = JavaVersion.VERSION_1_9
    }
}
