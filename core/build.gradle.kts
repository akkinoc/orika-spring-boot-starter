plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependency.management)
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

dependencies {
    api(libs.spring.boot.starter)
    api(libs.orika)
}

java {
    toolchain {
        languageVersion = libs.versions.java.map { JavaLanguageVersion.of(it) }
    }
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
            dependencies {
                implementation(libs.spring.boot.starter.test)
                implementation(libs.kotest.assertions)
            }
            targets.all {
                testTask {
                    jvmArgs("--add-opens=java.base/java.lang=ALL-UNNAMED")
                }
            }
        }
    }
}
