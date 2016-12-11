package net.rakugakibox.spring.boot.orika.sample;

import lombok.Data;

/**
 * The source object of person data.
 */
@Data
public class PersonSource {

    /**
     * The first name.
     */
    private String firstName;

    /**
     * The last name.
     */
    private String lastName;

    /**
     * The age.
     */
    private int age;

}
