rootProject.name = "orika-spring-boot-starter"

include("core")
include("examples:simple-java")
include("examples:simple-kotlin")

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
