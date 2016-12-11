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

## Supported versions

This artifact supports the following versions.  
Older versions may also work, but we have not tested it.  

* Java 8
* Spring Boot 1.4.0 or higher
* Orika 1.5.0 or higher

## Usage

### Adding dependency

This artifact is published on maven central repository.  
If you are using maven, add the following dependency.  

```xml
<dependency>
    <groupId>net.rakugakibox.spring.boot</groupId>
    <artifactId>orika-spring-boot-starter</artifactId>
    <version>0.1.0</version>
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

## Customizing

### Customizing `MapperFactory`

If you need to customize the `MapperFactory`,  
create an instance of `OrikaMapperFactoryConfigurer` within the application context.  

For example:  

```java
@Component
public class PersonMapping implements OrikaMapperFactoryConfigurer {
    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(PersonSource.class, PersonDestination.class)
                .field("firstName", "givenName")
                .field("lastName", "sirName")
                .byDefault()
                .register();
    }
}
```

#### See Also: Orika User Guide

* [Declarative Mapping Configuration]
* [Advanced Mapping Configurations]

[Declarative Mapping Configuration]: http://orika-mapper.github.io/orika-docs/mappings-via-classmapbuilder.html
[Advanced Mapping Configurations]: http://orika-mapper.github.io/orika-docs/advanced-mappings.html

### Customizing `MapperFactoryBuilder`

If you need to customize the `MapperFactoryBuilder`,  
create an instance of `OrikaMapperFactoryBuilderConfigurer` within the application context.  

For example:  

```java
@Component
public class CustomOrikaMapperFactoryBuilderConfigurer implements OrikaMapperFactoryBuilderConfigurer {
    @Override
    public void configure(MapperFactoryBuilder<?, ?> mapperFactoryBuilder) {
        // Your customization code.
    }
}
```

#### See Also: Orika User Guide

* [MapperFactory Configuration]

[MapperFactory Configuration]: http://orika-mapper.github.io/orika-docs/mapper-factory.html

## Configuration properties

This artifact provides the following configuration properties.  
These can be configured by your `application.yml` / `application.properties`.  

```yaml
orika:
  # Whether enable auto-configuration.
  # Defaults to true.
  enabled: true
  # Whether to use built-in converters.
  # By default, follow Orika.
  useBuiltinConverters: true
  # Whether to use auto-mapping.
  # By default, follow Orika.
  useAutoMapping: true
  # Whether to map null values.
  # By default, follow Orika.
  mapNulls: true
  # Whether to dump the current state of the mapping infrastructure objects
  # upon occurrence of an exception while mapping.
  # By default, follow Orika.
  dumpStateOnException: true
  # Whether the class-map should be considered 'abstract'.
  # By default, follow Orika.
  favorExtension: false
  # Whether full field context should be captured.
  # By default, follow Orika.
  captureFieldContext: false
```

## Contributing

Bug reports and pull requests are welcome :)  

## License

Licensed under the [Apache License, Version 2.0].  

[Apache License, Version 2.0]: LICENSE.txt
