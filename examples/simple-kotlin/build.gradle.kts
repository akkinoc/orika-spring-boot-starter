plugins {
    application
    kotlin("jvm") version "2.3.21"
    id("org.springframework.boot") version "4.0.6"
    id("io.spring.dependency-management") version "1.1.7"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("dev.akkinoc.spring.boot:orika-spring-boot-starter:4.0.1")
}

application {
    mainClass = "example.ApplicationKt"
    applicationDefaultJvmArgs = listOf("--add-opens=java.base/java.lang=ALL-UNNAMED")
}
