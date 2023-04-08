package guilherme.escarduca.MovieApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString
@JsonIgnoreProperties({"genre"})//when desirializing will make it so that all properties specified  will be ignored
public class MovieV1 {
    private String name;
    @JsonIgnore//will make it so one property is ignored.
    private String genre;


}
