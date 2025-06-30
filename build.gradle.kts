import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.vanniktech.mavenPublish) apply false
    id("maven-publish")
}

class GradleProperties {
    val propertyOrNull = properties.withDefault<String, Any?> { null }
    val group: String by propertyOrNull
    val version: String by propertyOrNull
    val artifactName: String by propertyOrNull
    val githubNickname: String by propertyOrNull
    val githubRepoName: String by propertyOrNull
    private val nosign: String? by propertyOrNull
    val requiresSignature = nosign.toBoolean().not()

    val githubRepoPath = "$githubNickname/$githubRepoName"
}

fun Project.androidNamespace(properties: GradleProperties): String = "${properties.group}.${properties.artifactName}.${this@androidNamespace.name}"
fun Project.moduleFullName(properties: GradleProperties): String = "${properties.artifactName}-${this@moduleFullName.name}"


val gradleProperties = GradleProperties()

subprojects {
    repositories {
        google()
        mavenCentral()
    }

    group = gradleProperties.group
    version = gradleProperties.version

    apply(plugin = "maven-publish")
    apply(plugin = "com.vanniktech.maven.publish")
    apply(plugin = "com.android.library")

    extensions.configure<com.android.build.gradle.LibraryExtension> {
        namespace = androidNamespace(gradleProperties)
    }

    extensions.configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

        if(gradleProperties.requiresSignature) signAllPublications()

        coordinates(group.toString(), moduleFullName(gradleProperties), version.toString())

        pom {
            name = "KMPByteUtil"
            description = "Byte utilities for Kotlin Multiplatform"
            inceptionYear = "2025"
            url = "https://github.com/${gradleProperties.githubRepoPath}"
            licenses {
                license {
                    name = "The Apache License, Version 2.0"
                    url = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                    distribution = "https://www.apache.org/licenses/LICENSE-2.0.txt"
                }
            }
            developers {
                developer {
                    id = gradleProperties.githubNickname
                    name = "Alen MapuH"
                    url = "https://github.com/${gradleProperties.githubNickname}"
                }
            }
            scm {
                url = "https://github.com/${gradleProperties.githubRepoPath}"
                connection =
                    "scm:git:git://github.com/${gradleProperties.githubRepoPath}.git"
                developerConnection =
                    "scm:git:ssh://git@github.com/${gradleProperties.githubRepoPath}.git"
            }
        }
    }

//
//    // TODO: remove after https://youtrack.jetbrains.com/issue/KT-46466 is fixed
//    project.tasks.withType(AbstractPublishToMaven::class.java).configureEach {
//        dependsOn(project.tasks.withType(Sign::class.java))
//    }
}