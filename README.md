# Spring Boot Starter for Orika

[![Maven Central][Maven Central Badge]][Maven Central]
[![CircleCI][CircleCI Badge]][CircleCI]

[Maven Central Badge]: https://maven-badges.herokuapp.com/maven-central/net.rakugakibox.spring.boot/orika-spring-boot-starter/badge.svg
[Maven Central]: https://maven-badges.herokuapp.com/maven-central/net.rakugakibox.spring.boot/orika-spring-boot-starter
[CircleCI Badge]: https://circleci.com/gh/akihyro/orika-spring-boot-starter.svg?style=shield
[CircleCI]: https://circleci.com/gh/akihyro/orika-spring-boot-starter

Auto-configures [Orika (Java Bean mapping framework)] to [Spring Boot] application context.  

[Orika (Java Bean mapping framework)]: http://orika-mapper.github.io/orika-docs/
[Spring Boot]: https://projects.spring.io/spring-boot/

## Usage

### Adding dependency

This artifact is published on maven central repository.  
If you are using maven, add the following dependency.  

```xml
<dependency>
    <groupId>net.rakugakibox.spring.boot</groupId>
    <artifactId>orika-spring-boot-starter</artifactId>
    <version>0.1</version>
</dependency>
```

### Injecting `MapperFacade`

The `MapperFacade` (Orika's mapper interface) is managed by the application context.  
Inject the `MapperFacade` into your code.  

For example:

```java
@Autowired
private MapperFacade mapperFacade;
```

### Mapping your beans

Map your beans using `MapperFacade`.  

For example:

```java
PersonSource source = new PersonSource();
source.setFirstName("John");
source.setLastName("Smith");
source.setAge(23);
PersonDestination destination = mapperFacade.map(source, PersonDestination.class);
```

## License

Licensed under the [Apache License, Version 2.0].  

[Apache License, Version 2.0]: LICENSE.txt
