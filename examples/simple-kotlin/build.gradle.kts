import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    application
}

dependencies {
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))
    implementation(kotlin("reflect"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("dev.akkinoc.spring.boot:orika-spring-boot-starter")
}

application {
    mainClass = "example.ApplicationKt"
    applicationDefaultJvmArgs = listOf("--add-opens=java.base/java.lang=ALL-UNNAMED")
}
