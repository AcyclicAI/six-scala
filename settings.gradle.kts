//val versions = gradle.rootProject.versions()

include("six")
project(":six").projectDir = file("module")

include(
    ":six:typetag",
    ":six:unused",
    ":six:spark"
)

pluginManagement.repositories {
    gradlePluginPortal()
    mavenCentral()
    // maven("https://dl.bintray.com/kotlin/kotlin-dev")
}

includeBuild("../buildSrc") {
    name = "shared-build-logic"
    dependencySubstitution {
        substitute(module("ai.acyclic:buildSrc")).using(project(":"))
    }
}
