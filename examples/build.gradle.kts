subprojects {
    configurations.configureEach {
        resolutionStrategy.dependencySubstitution {
            "orika-spring-boot-starter".also { substitute(module("$group:$it")).using(project(":$it")) }
        }
    }
}
