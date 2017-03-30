package net.rakugakibox.spring.boot.orika;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
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
@RequiredArgsConstructor
@Slf4j
public class OrikaAutoConfiguration {

    /**
     * The configuration properties for Orika.
     */
    private final OrikaProperties orikaProperties;

    /**
     * The configurers for {@link MapperFactoryBuilder}.
     */
    private final Optional<List<OrikaMapperFactoryBuilderConfigurer>> orikaMapperFactoryBuilderConfigurers;

    /**
     * The configurers for {@link MapperFactory}.
     */
    private final Optional<List<OrikaMapperFactoryConfigurer>> orikaMapperFactoryConfigurers;

    /**
     * Creates a {@link MapperFactoryBuilder}.
     *
     * @return a {@link MapperFactoryBuilder}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder() {
        DefaultMapperFactory.Builder orikaMapperFactoryBuilder = new DefaultMapperFactory.Builder();
        orikaProperties.getUseBuiltinConverters().ifPresent(orikaMapperFactoryBuilder::useBuiltinConverters);
        orikaProperties.getUseAutoMapping().ifPresent(orikaMapperFactoryBuilder::useAutoMapping);
        orikaProperties.getMapNulls().ifPresent(orikaMapperFactoryBuilder::mapNulls);
        orikaProperties.getDumpStateOnException().ifPresent(orikaMapperFactoryBuilder::dumpStateOnException);
        orikaProperties.getFavorExtension().ifPresent(orikaMapperFactoryBuilder::favorExtension);
        orikaProperties.getCaptureFieldContext().ifPresent(orikaMapperFactoryBuilder::captureFieldContext);
        orikaMapperFactoryBuilderConfigurers
                .orElseGet(Collections::emptyList)
                .forEach(configurer -> configurer.configure(orikaMapperFactoryBuilder));
        log.debug("Created a MapperFactoryBuilder: [{}]", orikaMapperFactoryBuilder);
        return orikaMapperFactoryBuilder;
    }

    /**
     * Creates a {@link MapperFactory}.
     *
     * @param orikaMapperFactoryBuilder the {@link MapperFactoryBuilder}.
     * @return a {@link MapperFactory}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFactory orikaMapperFactory(MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder) {
        MapperFactory orikaMapperFactory = orikaMapperFactoryBuilder.build();
        orikaMapperFactoryConfigurers
                .orElseGet(Collections::emptyList)
                .forEach(configurer -> configurer.configure(orikaMapperFactory));
        log.debug("Created a MapperFactory: [{}]", orikaMapperFactory);
        return orikaMapperFactory;
    }

    /**
     * Creates a {@link MapperFacade}.
     *
     * @param orikaMapperFactory the {@link MapperFactory}.
     * @return a {@link MapperFacade}.
     */
    @Bean
    @ConditionalOnMissingBean
    public MapperFacade orikaMapperFacade(MapperFactory orikaMapperFactory) {
        MapperFacade orikaMapperFacade = orikaMapperFactory.getMapperFacade();
        log.debug("Created a MapperFacade: [{}]", orikaMapperFacade);
        return orikaMapperFacade;
    }

}
