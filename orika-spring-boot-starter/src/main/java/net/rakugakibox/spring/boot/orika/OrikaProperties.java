package net.rakugakibox.spring.boot.orika;

import java.util.Optional;

import lombok.Data;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The auto-configuration properties for Orika.
 */
@ConfigurationProperties("orika")
@Data
public class OrikaProperties {

    /**
     * Whether to enable auto-configuration.
     * Defaults to {@code true}.
     */
    private Boolean enabled = true;

    /**
     * Whether to use built-in converters.
     * By default, follows Orika.
     *
     * @see DefaultMapperFactory.MapperFactoryBuilder#useBuiltinConverters(boolean)
     */
    private Optional<Boolean> useBuiltinConverters = Optional.empty();

    /**
     * Whether to use auto-mapping.
     * By default, follows Orika.
     *
     * @see DefaultMapperFactory.MapperFactoryBuilder#useAutoMapping(boolean)
     */
    private Optional<Boolean> useAutoMapping = Optional.empty();

    /**
     * Whether to map null values.
     * By default, follows Orika.
     *
     * @see DefaultMapperFactory.MapperFactoryBuilder#mapNulls(boolean)
     */
    private Optional<Boolean> mapNulls = Optional.empty();

    /**
     * Whether to dump the current state of the mapping infrastructure objects
     * upon occurrence of an exception while mapping.
     * By default, follows Orika.
     *
     * @see DefaultMapperFactory.MapperFactoryBuilder#dumpStateOnException(boolean)
     */
    private Optional<Boolean> dumpStateOnException = Optional.empty();

    /**
     * Whether the class-map should be considered 'abstract'.
     * By default, follows Orika.
     *
     * @see DefaultMapperFactory.MapperFactoryBuilder#favorExtension(boolean)
     */
    private Optional<Boolean> favorExtension = Optional.empty();

    /**
     * Whether full field context should be captured.
     * By default, follows Orika.
     *
     * @see DefaultMapperFactory.MapperFactoryBuilder#captureFieldContext(boolean)
     */
    private Optional<Boolean> captureFieldContext = Optional.empty();

}
