package guilherme.escarduca.MovieApi.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@NoArgsConstructor
public class DirectorModel extends RepresentationModel<DirectorModel> {

    private Director director;

    public DirectorModel(Director director) {
        this.director = director;
    }

    public int getId(){
        return director.getId();
    }

    public String getName(){
        return director.getName();
    }

    public DirectorDetail getDirectorDetail(){
        return director.getDirectorDetail();
    }
//    public String getFavoriteMovie(){
//        return director.getDirectorDetail().getFavoriteMovie();
//    }
}
