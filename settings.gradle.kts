plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "orika-spring-boot-starter"

include("orika-spring-boot-starter")
include("examples:simple-java")
include("examples:simple-kotlin")
