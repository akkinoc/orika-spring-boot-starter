package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.MapperFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The test to configure {@link MapperFactory}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrikaMapperFactoryConfiguringTest {

    /**
     * The {@link MapperFactory}.
     */
    @Autowired
    protected MapperFactory orikaMapperFactory;

    /**
     * The configuration 1 of {@link MapperFactory}.
     */
    @Autowired
    @Qualifier("orikaMapperFactoryConfiguration1")
    protected OrikaMapperFactoryConfiguration orikaMapperFactoryConfiguration1;

    /**
     * The configuration 2 of {@link MapperFactory}.
     */
    @Autowired
    @Qualifier("orikaMapperFactoryConfiguration2")
    protected OrikaMapperFactoryConfiguration orikaMapperFactoryConfiguration2;

    /**
     * Tests the {@link OrikaMapperFactoryConfigurer}s.
     */
    @Test
    public void orikaMapperFactoryConfigurers() {
        assertThat(orikaMapperFactoryConfiguration1.orikaMapperFactory).isSameAs(orikaMapperFactory);
        assertThat(orikaMapperFactoryConfiguration2.orikaMapperFactory).isSameAs(orikaMapperFactory);
    }

    /**
     * The context configuration.
     */
    @Configuration
    @EnableAutoConfiguration
    public static class ContextConfiguration {

        /**
         * Creates a configuration 1 of {@link MapperFactory}.
         *
         * @return a configuration 1 of {@link MapperFactory}.
         */
        @Bean
        public OrikaMapperFactoryConfiguration orikaMapperFactoryConfiguration1() {
            return new OrikaMapperFactoryConfiguration();
        }

        /**
         * Creates a configuration 2 of {@link MapperFactory}.
         *
         * @return a configuration 2 of {@link MapperFactory}.
         */
        @Bean
        public OrikaMapperFactoryConfiguration orikaMapperFactoryConfiguration2() {
            return new OrikaMapperFactoryConfiguration();
        }

    }

    /**
     * The configuration of {@link MapperFactory}.
     */
    public static class OrikaMapperFactoryConfiguration implements OrikaMapperFactoryConfigurer {

        /**
         * The passed {@link MapperFactory}.
         */
        private MapperFactory orikaMapperFactory;

        /** {@inheritDoc} */
        @Override
        public void configure(MapperFactory orikaMapperFactory) {
            this.orikaMapperFactory = orikaMapperFactory;
        }

    }

}
