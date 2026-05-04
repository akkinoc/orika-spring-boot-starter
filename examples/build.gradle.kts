subprojects {
    configurations.configureEach {
        resolutionStrategy.dependencySubstitution {
            substitute(module("dev.akkinoc.spring.boot:orika-spring-boot-starter")).using(project(":core"))
        }
    }
}
