package guilherme.escarduca.MovieApi.Converters;

import guilherme.escarduca.MovieApi.Exceptions.DirectorException;
import guilherme.escarduca.MovieApi.Models.MovieModel;
import guilherme.escarduca.MovieApi.Models.MovieEntity;
import guilherme.escarduca.MovieApi.Repos.DirectorDao;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieConverter extends ModelMapper{



    @Autowired
    private DirectorDao directorDao;

    public MovieModel convertToDTO(MovieEntity movie) {
        MovieModel movieModel = this.map(movie, MovieModel.class);
        movieModel.setDirectorName(movie.getDirector().getName());
        return movieModel;
    }

    public MovieEntity convertToEntity(MovieModel movieModel) {
        MovieEntity movie = this.map(movieModel, MovieEntity.class);
        movie.setDirector(directorDao.findByName(movieModel.getDirectorName()).orElseThrow(DirectorException::directorExceptionNotFound));
        return movie;
    }
}

