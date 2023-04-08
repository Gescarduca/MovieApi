package guilherme.escarduca.MovieApi.Models;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor @JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String value1;
    private String value2;
    private String value3;

}
