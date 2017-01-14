package net.rakugakibox.spring.boot.orika;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The auto-configuration for Orika.
 */
@Configuration
@ConditionalOnProperty(name = "orika.enabled", matchIfMissing = true)
@EnableConfigurationProperties(OrikaProperties.class)
@Slf4j
public class OrikaAutoConfiguration {

    /**
     * Creates a {@link DefaultMapperFactory.MapperFactoryBuilder}.
     *
     * @param orikaProperties the configuration properties for Orika.
     * @param mapperFactoryBuilderConfigurers the configurers of {@link DefaultMapperFactory.MapperFactoryBuilder}.
     * @return a {@link DefaultMapperFactory.MapperFactoryBuilder}.
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultMapperFactory.MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder(
            OrikaProperties orikaProperties,
            Optional<List<OrikaMapperFactoryBuilderConfigurer>> mapperFactoryBuilderConfigurers
    ) {
        DefaultMapperFactory.Builder mapperFactoryBuilder = new DefaultMapperFactory.Builder();
        orikaProperties.getUseBuiltinConverters().ifPresent(mapperFactoryBuilder::useBuiltinConverters);
        orikaProperties.getUseAutoMapping().ifPresent(mapperFactoryBuilder::useAutoMapping);
        orikaProperties.getMapNulls().ifPresent(mapperFactoryBuilder::mapNulls);
        orikaProperties.getDumpStateOnException().ifPresent(mapperFactoryBuilder::dumpStateOnException);
        orikaProperties.getFavorExtension().ifPresent(mapperFactoryBuilder::favorExtension);
        orikaProperties.getCaptureFieldContext().ifPresent(mapperFactoryBuilder::captureFieldContext);
        mapperFactoryBuilderConfigurers
                .orElseGet(Collections::emptyList)
                .forEach(configurer -> configurer.configure(mapperFactoryBuilder));
        log.debug("Created a DefaultMapperFactory.MapperFactoryBuilder: [{}]", mapperFactoryBuilder);
        return mapperFactoryBuilder;
    }

    /**
     * Creates a {@link MapperFactory}.
     *
     * @param mapperFactoryBuilder the {@link DefaultMapperFactory.MapperFactoryBuilder}.
     * @param mapperFactoryConfigurers the configurers of {@link MapperFactory}.
     * @return a {@link MapperFactory}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFactory orikaMapperFactory(
            DefaultMapperFactory.MapperFactoryBuilder<?, ?> mapperFactoryBuilder,
            Optional<List<OrikaMapperFactoryConfigurer>> mapperFactoryConfigurers
    ) {
        MapperFactory mapperFactory = mapperFactoryBuilder.build();
        mapperFactoryConfigurers
                .orElseGet(Collections::emptyList)
                .forEach(configurer -> configurer.configure(mapperFactory));
        log.debug("Created a MapperFactory: [{}]", mapperFactory);
        return mapperFactory;
    }

    /**
     * Creates a {@link MapperFacade}.
     *
     * @param mapperFactory the {@link MapperFactory}.
     * @return a {@link MapperFacade}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFacade orikaMapperFacade(MapperFactory mapperFactory) {
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        log.debug("Created a MapperFacade: [{}]", mapperFacade);
        return mapperFacade;
    }

}
