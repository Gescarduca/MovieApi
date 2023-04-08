package guilherme.escarduca.MovieApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "director_detail")
@Getter @Setter
@NoArgsConstructor
public class DirectorDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "favorite_movie")
    private String favoriteMovie;


    @JsonIgnore
    @OneToOne(mappedBy = "directorDetail", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})//mapped by the property in the other class, also we have define all these cascade types with only delete missing because
    //the only situation where we DONT want the Director that is associated to be updated accordingly is if and when we delete the details pertaining to that director.
    private Director director;
    //@Column(name = "hobbies")
    //private List<String> hobby;

    //


    @Override
    public String toString() {
        return "DirectorDetail{" +
                "id=" + id +
                ", favoriteMovie='" + favoriteMovie + '\'' +
                '}';
    }
}
