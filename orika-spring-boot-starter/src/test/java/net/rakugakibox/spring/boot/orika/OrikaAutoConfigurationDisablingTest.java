package net.rakugakibox.spring.boot.orika;

import java.util.Optional;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * The test to disable {@link OrikaAutoConfiguration}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest("orika.enabled=false")
public class OrikaAutoConfigurationDisablingTest {

    /**
     * The configuration properties for Orika.
     */
    @Autowired
    protected Optional<OrikaProperties> orikaProperties;

    /**
     * The {@link MapperFactoryBuilder}.
     */
    @Autowired
    protected Optional<MapperFactoryBuilder<?, ?>> orikaMapperFactoryBuilder;

    /**
     * The {@link MapperFactory}.
     */
    @Autowired
    protected Optional<MapperFactory> orikaMapperFactory;

    /**
     * The {@link MapperFacade}.
     */
    @Autowired
    protected Optional<MapperFacade> orikaMapperFacade;

    /**
     * Tests the configuration properties for Orika.
     */
    @Test
    public void orikaProperties() {
        assertThat(orikaProperties).isEmpty();
    }

    /**
     * Tests the {@link MapperFactoryBuilder}.
     */
    @Test
    public void orikaMapperFactoryBuilder() {
        assertThat(orikaMapperFactoryBuilder).isEmpty();
    }

    /**
     * Tests the {@link MapperFactory}.
     */
    @Test
    public void orikaMapperFactory() {
        assertThat(orikaMapperFactory).isEmpty();
    }

    /**
     * Tests the {@link MapperFacade}.
     */
    @Test
    public void orikaMapperFacade() {
        assertThat(orikaMapperFacade).isEmpty();
    }

    /**
     * The context configuration.
     */
    @Configuration
    @EnableAutoConfiguration
    public static class ContextConfiguration {
    }

}
