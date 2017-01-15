package net.rakugakibox.spring.boot.orika;

import java.util.Optional;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * The test of {@link OrikaAutoConfiguration} when disabled.
 */
@RunWith(SpringRunner.class)
@SpringBootTest("orika.enabled=false")
public class OrikaAutoConfigurationDisabledTest {

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
        assertThat(orikaProperties).isNotPresent();
    }

    /**
     * Tests the {@link MapperFactoryBuilder}.
     */
    @Test
    public void orikaMapperFactoryBuilder() {
        assertThat(orikaMapperFactoryBuilder).isNotPresent();
    }

    /**
     * Tests the {@link MapperFactory}.
     */
    @Test
    public void orikaMapperFactory() {
        assertThat(orikaMapperFactory).isNotPresent();
    }

    /**
     * Tests the {@link MapperFacade}.
     */
    @Test
    public void orikaMapperFacade() {
        assertThat(orikaMapperFacade).isNotPresent();
    }

    /**
     * The context configuration.
     */
    @Configuration
    @EnableAutoConfiguration
    public static class ContextConfiguration {
    }

}
