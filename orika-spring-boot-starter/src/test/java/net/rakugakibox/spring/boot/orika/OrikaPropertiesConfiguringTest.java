package net.rakugakibox.spring.boot.orika;

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
 * The test to configure {@link OrikaProperties}.
 */
@RunWith(SpringRunner.class)
@SpringBootTest({
        "orika.useBuiltinConverters=false",
        "orika.useAutoMapping=false",
        "orika.mapNulls=false",
        "orika.dumpStateOnException=true",
        "orika.favorExtension=true",
        "orika.captureFieldContext=true"
})
public class OrikaPropertiesConfiguringTest {

    /**
     * The {@link MapperFactoryBuilder}.
     */
    @Autowired
    protected MapperFactoryBuilder<?, ?> orikaMapperFactoryBuilder;

    /**
     * Tests the {@link MapperFactoryBuilder}.
     */
    @Test
    public void orikaMapperFactoryBuilder() {
        assertThat(orikaMapperFactoryBuilder)
                .hasFieldOrPropertyWithValue("useBuiltinConverters", false)
                .hasFieldOrPropertyWithValue("useAutoMapping", false)
                .hasFieldOrPropertyWithValue("mapNulls", false)
                .hasFieldOrPropertyWithValue("dumpStateOnException", true)
                .hasFieldOrPropertyWithValue("favorExtension", true)
                .hasFieldOrPropertyWithValue("captureFieldContext", true);
    }

    /**
     * The context configuration.
     */
    @Configuration
    @EnableAutoConfiguration
    public static class ContextConfiguration {
    }

}
