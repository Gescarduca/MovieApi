package guilherme.escarduca.MovieApi.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import guilherme.escarduca.MovieApi.CustomAnnotations.MovieRevenue;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name ="movies")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class MovieEntity {


/*    Title The title of the movie
    Date The launch date
    Rank Rating (0 to 10)
    Revenue The revenue generated by the movie*/
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title",unique = true)//create the columns with the constraint that title has to be unique
    @Size(min=5, max = 50, message = "Title is outside of range, number of chars must be between 5 and 50")
    @NotBlank(message = "Title cannot be blank")

    //@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 chars possible")
    //@JsonProperty("movie_title")//allows you to manipulate the field names being sent out

    /*
    Note: Glad to hear it worked! Yes, the @JsonProperty annotation is useful when mapping between Java objects and JSON.
     When deserializing JSON to Java objects (as in the case of a POST request), the JSON property names must match the corresponding Java class field names.
     However, when serializing Java objects to JSON (as in the case of a response to a GET request), the JSON property names can be customized using the @JsonProperty annotation.
     In your case, it seems like the JSON payload being sent in the POST request did not have the "movie_title" field, so the deserialization failed.
     By adding the @JsonProperty("movie_title") annotation to the title field, you were able to map the "title" property in the JSON payload to the title field in the Java object.*/
    private String title;
    @Column(name = "launch_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "LaunchDate cannot be null")
    @PastOrPresent(message = "movie cannot be from the future, oh time traveller")
    private LocalDate launchDate;
    @Column(name = "rating")
    @Range(min = 0, max = 10, message = "Rating needs to be between 0 and 10")
    private int rating;
    @Column(name = "revenue")
    @MovieRevenue(value = 100.00, message = "must be above 1 custom custom version")//because we have defaults in the constraint we could have just called the annotation and not define any values like this @MovieRevenue
    private double revenue;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private List<ReviewEntity> reviews;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "movies_actors", joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<ActorEntity> actors;
}