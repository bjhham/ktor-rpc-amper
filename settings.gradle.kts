rootProject.name = "com.example.ktor-rpc"

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://packages.jetbrains.team/maven/p/amper/amper")
        maven("https://www.jetbrains.com/intellij-repository/releases")
        maven("https://packages.jetbrains.team/maven/p/ij/intellij-dependencies")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }

}

plugins {
    id("org.jetbrains.amper.settings.plugin").version("0.4.0")
}

include(":server")
include(":core")
include(":client")
