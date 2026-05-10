rootProject.name = "orika-spring-boot-starter"

include("orika-spring-boot-starter")
include("examples:simple-java")
include("examples:simple-kotlin")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
