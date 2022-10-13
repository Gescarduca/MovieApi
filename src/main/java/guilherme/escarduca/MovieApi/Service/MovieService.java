package guilherme.escarduca.MovieApi.Service;

import guilherme.escarduca.MovieApi.Models.MovieModel;
import guilherme.escarduca.MovieApi.Models.MovieModel;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {

    public MovieModel findMovieById(int id);
    public MovieModel save(MovieModel MovieModel);
    public MovieModel update(MovieModel MovieModel, int id);
    public List<MovieModel> getMovies();
    public List<MovieModel> getMoviesByLaunchDate(LocalDate date);
    public void deleteMovieById(int id);

}
