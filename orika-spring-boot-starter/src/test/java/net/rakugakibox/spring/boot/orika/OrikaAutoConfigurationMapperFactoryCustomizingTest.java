package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The {@link OrikaAutoConfiguration}'s test cases when customize {@link MapperFactory}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrikaAutoConfigurationMapperFactoryCustomizingTest {

    /**
     * The {@link MapperFactory}.
     */
    @Autowired
    protected MapperFactory orikaMapperFactory;

    /**
     * The {@link MapperFactory}'s configuration 1.
     */
    @Autowired
    @Qualifier("orikaMapperFactoryConfiguration1")
    protected MapperFactoryConfiguration mapperFactoryConfiguration1;

    /**
     * The {@link MapperFactory}'s configuration 1.
     */
    @Autowired
    @Qualifier("orikaMapperFactoryConfiguration2")
    protected MapperFactoryConfiguration mapperFactoryConfiguration2;

    /**
     * Tests the {@link OrikaAutoConfiguration#orikaMapperFactory(MapperFactoryBuilder)}.
     */
    @Test
    public void orikaMapperFactory_configurerShouldBeCalled() {
        assertThat(orikaMapperFactory)
                .isSameAs(mapperFactoryConfiguration1.mapperFactory)
                .isSameAs(mapperFactoryConfiguration2.mapperFactory);
    }

    /**
     * The context configuration.
     */
    @Configuration
    @EnableAutoConfiguration
    public static class ContextConfiguration {

        /**
         * Creates a {@link MapperFactory}'s configuration 1.
         *
         * @return a {@link MapperFactory}'s configuration 1.
         */
        @Bean
        public MapperFactoryConfiguration orikaMapperFactoryConfiguration1() {
            return new MapperFactoryConfiguration();
        }

        /**
         * Creates a {@link MapperFactory}'s configuration 2.
         *
         * @return a {@link MapperFactory}'s configuration 2.
         */
        @Bean
        public MapperFactoryConfiguration orikaMapperFactoryConfiguration2() {
            return new MapperFactoryConfiguration();
        }

    }

    /**
     * The {@link MapperFactory}'s configuration.
     */
    public static class MapperFactoryConfiguration implements OrikaMapperFactoryConfigurer {

        /**
         * The passed {@link MapperFactory}.
         */
        private MapperFactory mapperFactory;

        /** {@inheritDoc} */
        @Override
        public void configure(MapperFactory mapperFactory) {
            this.mapperFactory = mapperFactory;
        }

    }

}
