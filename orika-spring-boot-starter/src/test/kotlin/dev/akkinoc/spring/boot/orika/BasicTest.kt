package dev.akkinoc.spring.boot.orika

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import ma.glasnost.orika.MapperFacade
import ma.glasnost.orika.MapperFactory
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.ReflectionTestUtils.getField

/**
 * Tests the case where the configuration is the default.
 */
@SpringBootTest
class BasicTest {

    @Test
    fun `Provides the configuration properties for Orika`(@Autowired orikaProperties: OrikaProperties?) {
        orikaProperties.shouldNotBeNull()
        orikaProperties.enabled.shouldBe(true)
        orikaProperties.useBuiltinConverters.shouldBeNull()
        orikaProperties.useAutoMapping.shouldBeNull()
        orikaProperties.mapNulls.shouldBeNull()
        orikaProperties.dumpStateOnException.shouldBeNull()
        orikaProperties.favorExtension.shouldBeNull()
        orikaProperties.captureFieldContext.shouldBeNull()
    }

    @Test
    fun `Provides the MapperFactoryBuilder`(@Autowired orikaMapperFactoryBuilder: MapperFactoryBuilder<*, *>?) {
        orikaMapperFactoryBuilder.shouldNotBeNull()
        getField(orikaMapperFactoryBuilder, "useBuiltinConverters").shouldBe(true)
        getField(orikaMapperFactoryBuilder, "useAutoMapping").shouldBe(true)
        getField(orikaMapperFactoryBuilder, "mapNulls").shouldBe(true)
        getField(orikaMapperFactoryBuilder, "dumpStateOnException").shouldBe(false)
        getField(orikaMapperFactoryBuilder, "favorExtension").shouldBe(false)
        getField(orikaMapperFactoryBuilder, "captureFieldContext").shouldBe(false)
    }

    @Test
    fun `Provides the MapperFactory`(@Autowired orikaMapperFactory: MapperFactory?) {
        orikaMapperFactory.shouldNotBeNull()
    }

    @Test
    fun `Provides the MapperFacade`(@Autowired orikaMapperFacade: MapperFacade?) {
        orikaMapperFacade.shouldNotBeNull()
    }

}
