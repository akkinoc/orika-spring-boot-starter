package example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonSource {
    private String firstName = "";
    private String lastName = "";
    private int age = 0;
}
