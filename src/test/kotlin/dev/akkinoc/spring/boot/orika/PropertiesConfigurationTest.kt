package dev.akkinoc.spring.boot.orika

import io.kotest.matchers.shouldBe
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.ReflectionTestUtils.getField

/**
 * Tests the case where the configuration properties are configured.
 */
@SpringBootTest(
    properties = [
        "orika.enabled=true",
        "orika.use-builtin-converters=false",
        "orika.use-auto-mapping=false",
        "orika.map-nulls=false",
        "orika.dump-state-on-exception=true",
        "orika.favor-extension=true",
        "orika.capture-field-context=true",
    ]
)
class PropertiesConfigurationTest {

    @Test
    fun `Configures the MapperFactoryBuilder`(@Autowired orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>) {
        getField(orikaMapperFactoryBuilder, "useBuiltinConverters").shouldBe(false)
        getField(orikaMapperFactoryBuilder, "useAutoMapping").shouldBe(false)
        getField(orikaMapperFactoryBuilder, "mapNulls").shouldBe(false)
        getField(orikaMapperFactoryBuilder, "dumpStateOnException").shouldBe(true)
        getField(orikaMapperFactoryBuilder, "favorExtension").shouldBe(true)
        getField(orikaMapperFactoryBuilder, "captureFieldContext").shouldBe(true)
    }

}
