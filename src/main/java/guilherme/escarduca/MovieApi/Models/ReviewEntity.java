package guilherme.escarduca.MovieApi.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity @Table(name = "reviews") @Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ReviewEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
    private int id;

    @Column(name = "comments")
    private String comment;
}
