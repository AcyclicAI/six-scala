//val versions = gradle.rootProject.versions()

include("six")
project(":six").projectDir = file("module")

include(
    ":six:typetag",
    ":six:unused",
    ":six:spark",
    ":six:congruence"
)

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    includeBuild("../buildSrc") {
        name = "shared-build-logic"
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

includeBuild("../buildSrc") {
    name = "shared-build-logic"
    dependencySubstitution {
        substitute(module("ai.acyclic:buildSrc")).using(project(":"))
    }
}
