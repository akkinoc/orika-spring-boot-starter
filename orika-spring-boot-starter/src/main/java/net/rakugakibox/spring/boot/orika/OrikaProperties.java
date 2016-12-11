package net.rakugakibox.spring.boot.orika;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import ma.glasnost.orika.impl.DefaultMapperFactory.MapperFactoryBuilder;

/**
 * The auto-configuration properties for Orika.
 */
@ConfigurationProperties("orika")
@Data
public class OrikaProperties {

    /**
     * Whether enable auto-configuration.
     * Defaults to {@code true}.
     */
    private Boolean enabled = true;

    /**
     * Whether to use built-in converters.
     * By default, follow Orika.
     *
     * @see MapperFactoryBuilder#useBuiltinConverters(boolean)
     */
    private Boolean useBuiltinConverters;

    /**
     * Whether to use auto-mapping.
     * By default, follow Orika.
     *
     * @see MapperFactoryBuilder#useAutoMapping(boolean)
     */
    private Boolean useAutoMapping;

    /**
     * Whether to map null values.
     * By default, follow Orika.
     *
     * @see MapperFactoryBuilder#mapNulls(boolean)
     */
    private Boolean mapNulls;

    /**
     * Whether to dump the current state of the mapping infrastructure objects
     * upon occurrence of an exception while mapping.
     * By default, follow Orika.
     *
     * @see MapperFactoryBuilder#dumpStateOnException(boolean)
     */
    private Boolean dumpStateOnException;

    /**
     * Whether the class-map should be considered 'abstract'.
     * By default, follow Orika.
     *
     * @see MapperFactoryBuilder#favorExtension(boolean)
     */
    private Boolean favorExtension;

    /**
     * Whether full field context should be captured.
     * By default, follow Orika.
     *
     * @see MapperFactoryBuilder#captureFieldContext(boolean)
     */
    private Boolean captureFieldContext;

}
