package guilherme.escarduca.MovieApi.Models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "directors")
@Setter @Getter
@NoArgsConstructor
public class Director {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;
    //private List<MovieModel> movies;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_detail_id")
    private DirectorDetail directorDetail;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "director", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<MovieEntity> movies;
}
