package guilherme.escarduca.MovieApi.Service;

import guilherme.escarduca.MovieApi.Models.MovieModel;
import guilherme.escarduca.MovieApi.Models.MovieEntity;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    public MovieModel findMovieById(int id);
    public MovieEntity save(MovieEntity MovieModel);
    public MovieEntity update(MovieEntity MovieModel, int id);
    public List<MovieEntity> getMovies();
    public List<MovieEntity> getMoviesByLaunchDate(LocalDate date);
    public void deleteMovieById(int id);

}
