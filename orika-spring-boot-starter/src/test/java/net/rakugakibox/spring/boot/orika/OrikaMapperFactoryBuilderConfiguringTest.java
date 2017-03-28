package net.rakugakibox.spring.boot.orika;

import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
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
 * The test to configure {@link MapperFactoryBuilder}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrikaMapperFactoryBuilderConfiguringTest {

    /**
     * The {@link MapperFactoryBuilder}.
     */
    @Autowired
    protected MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder;

    /**
     * The configuration 1 of {@link MapperFactoryBuilder}.
     */
    @Autowired
    @Qualifier("orikaMapperFactoryBuilderConfiguration1")
    protected OrikaMapperFactoryBuilderConfiguration orikaMapperFactoryBuilderConfiguration1;

    /**
     * The configuration 2 of {@link MapperFactoryBuilder}.
     */
    @Autowired
    @Qualifier("orikaMapperFactoryBuilderConfiguration2")
    protected OrikaMapperFactoryBuilderConfiguration orikaMapperFactoryBuilderConfiguration2;

    /**
     * Tests the {@link OrikaMapperFactoryBuilderConfigurer}s.
     */
    @Test
    public void orikaMapperFactoryBuilderConfigurers() {
        assertThat(orikaMapperFactoryBuilderConfiguration1.orikaMapperFactoryBuilder)
                .isSameAs(orikaMapperFactoryBuilder);
        assertThat(orikaMapperFactoryBuilderConfiguration2.orikaMapperFactoryBuilder)
                .isSameAs(orikaMapperFactoryBuilder);
    }

    /**
     * The context configuration.
     */
    @Configuration
    @EnableAutoConfiguration
    public static class ContextConfiguration {

        /**
         * Creates a configuration 1 of {@link MapperFactoryBuilder}.
         *
         * @return a configuration 1 of {@link MapperFactoryBuilder}.
         */
        @Bean
        public OrikaMapperFactoryBuilderConfiguration orikaMapperFactoryBuilderConfiguration1() {
            return new OrikaMapperFactoryBuilderConfiguration();
        }

        /**
         * Creates a configuration 2 of {@link MapperFactoryBuilder}.
         *
         * @return a configuration 2 of {@link MapperFactoryBuilder}.
         */
        @Bean
        public OrikaMapperFactoryBuilderConfiguration orikaMapperFactoryBuilderConfiguration2() {
            return new OrikaMapperFactoryBuilderConfiguration();
        }

    }

    /**
     * The configuration of {@link MapperFactoryBuilder}.
     */
    protected static class OrikaMapperFactoryBuilderConfiguration implements OrikaMapperFactoryBuilderConfigurer {

        /**
         * The passed {@link MapperFactoryBuilder}.
         */
        private MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder;

        /** {@inheritDoc} */
        @Override
        public void configure(MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder) {
            this.orikaMapperFactoryBuilder = orikaMapperFactoryBuilder;
        }

    }

}
