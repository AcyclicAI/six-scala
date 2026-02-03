//val versions = gradle.rootProject.versions()

include("six")
project(":six").projectDir = file("module")

include(
    ":six:typetag",
    ":six:unused",
    ":six:spark"
)

pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id.startsWith("ai.acyclic")) {
                useModule("ai.acyclic:buildSrc:1.0-SNAPSHOT")
            }
        }
    }
    repositories {
        gradlePluginPortal()
        mavenCentral()
        // maven("https://dl.bintray.com/kotlin/kotlin-dev")
    }
}

includeBuild("../buildSrc") {
    name = "shared-build-logic"
    dependencySubstitution {
        substitute(module("ai.acyclic:buildSrc")).using(project(":"))
    }
}
