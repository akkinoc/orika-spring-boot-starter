package example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDestination {
    private String givenName = "";
    private String sirName = "";
    private int age = 0;
}
