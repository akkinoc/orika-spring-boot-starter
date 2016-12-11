package net.rakugakibox.spring.boot.orika;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
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
     * The auto-configuration properties for Orika.
     */
    private final OrikaProperties orikaProperties;

    /**
     * The {@link MapperFactoryBuilder}'s configurers.
     */
    private final List<OrikaMapperFactoryBuilderConfigurer> mapperFactoryBuilderConfigurers;

    /**
     * The {@link MapperFactory}'s configurers.
     */
    private final List<OrikaMapperFactoryConfigurer> mapperFactoryConfigurers;

    /**
     * Constructs an instance.
     *
     * @param orikaProperties the auto-configuration properties for Orika.
     * @param mapperFactoryBuilderConfigurers the {@link MapperFactoryBuilder}'s configurers.
     * @param mapperFactoryConfigurers the {@link MapperFactory}'s configurers.
     */
    @Autowired
    public OrikaAutoConfiguration(
            OrikaProperties orikaProperties,
            Optional<List<OrikaMapperFactoryBuilderConfigurer>> mapperFactoryBuilderConfigurers,
            Optional<List<OrikaMapperFactoryConfigurer>> mapperFactoryConfigurers
    ) {
        this(
                orikaProperties,
                mapperFactoryBuilderConfigurers.orElseGet(Collections::emptyList),
                mapperFactoryConfigurers.orElseGet(Collections::emptyList)
        );
    }

    /**
     * Constructs an instance.
     *
     * @param orikaProperties the auto-configuration properties for Orika.
     * @param mapperFactoryBuilderConfigurers the {@link MapperFactoryBuilder}'s configurers.
     * @param mapperFactoryConfigurers the {@link MapperFactory}'s configurers.
     */
    public OrikaAutoConfiguration(
            OrikaProperties orikaProperties,
            List<OrikaMapperFactoryBuilderConfigurer> mapperFactoryBuilderConfigurers,
            List<OrikaMapperFactoryConfigurer> mapperFactoryConfigurers
    ) {
        this.orikaProperties = orikaProperties;
        this.mapperFactoryBuilderConfigurers = mapperFactoryBuilderConfigurers;
        this.mapperFactoryConfigurers = mapperFactoryConfigurers;
    }

    /**
     * Creates a {@link MapperFactoryBuilder}.
     *
     * @return a {@link MapperFactoryBuilder}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder() {
        log.debug("Creating a MapperFactoryBuilder");
        DefaultMapperFactory.Builder mapperFactoryBuilder = new DefaultMapperFactory.Builder();
        if (orikaProperties.getUseBuiltinConverters() != null) {
            mapperFactoryBuilder.useBuiltinConverters(orikaProperties.getUseBuiltinConverters());
        }
        if (orikaProperties.getUseAutoMapping() != null) {
            mapperFactoryBuilder.useAutoMapping(orikaProperties.getUseAutoMapping());
        }
        if (orikaProperties.getMapNulls() != null) {
            mapperFactoryBuilder.mapNulls(orikaProperties.getMapNulls());
        }
        if (orikaProperties.getDumpStateOnException() != null) {
            mapperFactoryBuilder.dumpStateOnException(orikaProperties.getDumpStateOnException());
        }
        if (orikaProperties.getFavorExtension() != null) {
            mapperFactoryBuilder.favorExtension(orikaProperties.getFavorExtension());
        }
        if (orikaProperties.getCaptureFieldContext() != null) {
            mapperFactoryBuilder.captureFieldContext(orikaProperties.getCaptureFieldContext());
        }
        mapperFactoryBuilderConfigurers.forEach(configurer -> configurer.configure(mapperFactoryBuilder));
        log.debug("Created a MapperFactoryBuilder: [{}]", mapperFactoryBuilder);
        return mapperFactoryBuilder;
    }

    /**
     * Creates a {@link MapperFactory}.
     *
     * @param mapperFactoryBuilder the {@link MapperFactoryBuilder}.
     * @return a {@link MapperFactory}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFactory orikaMapperFactory(MapperFactoryBuilder mapperFactoryBuilder) {
        log.debug("Creating a MapperFactory");
        MapperFactory mapperFactory = mapperFactoryBuilder.build();
        mapperFactoryConfigurers.forEach(configurer -> configurer.configure(mapperFactory));
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
        log.debug("Creating a MapperFactory");
        MapperFacade mapperFacade = mapperFactory.getMapperFacade();
        log.debug("Created a MapperFacade: [{}]", mapperFacade);
        return mapperFacade;
    }

}
