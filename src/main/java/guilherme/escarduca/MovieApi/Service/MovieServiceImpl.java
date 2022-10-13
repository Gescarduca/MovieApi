package guilherme.escarduca.MovieApi.Service;

import guilherme.escarduca.MovieApi.Exceptions.MovieNotFoundException;
import guilherme.escarduca.MovieApi.Models.MovieModel;
import guilherme.escarduca.MovieApi.Repos.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieDao movieDao;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public MovieModel findMovieById(int id) {
        Optional<MovieModel> movieModel = movieDao.findById(id);
        return movieModel.orElseThrow(()->new MovieNotFoundException(id));
    }

    @Override
    @Transactional
    public MovieModel save(MovieModel movieModel) {
        int id = movieDao.getMaxId()+1;
        movieModel.setId(id);
        return movieDao.save(movieModel);
    }

    @Override
    @Transactional
    public MovieModel update(MovieModel movieModel,int id){
        movieModel.setId(id);
        if(!movieDao.existsById(id)){
            throw new MovieNotFoundException(id);
        }
        return movieDao.save(movieModel);
    }

    @Override
    public List<MovieModel> getMovies() {
        // get stream of movies, transform them using map to dtos and pass to controller
        return movieDao.findAll();
    }

    @Override
    public List<MovieModel> getMoviesByLaunchDate(LocalDate date) {
        //get list of movies by date, create stream, use map to create dtos and collect the stream of dtos to return to controller
        return movieDao.findByLaunchDateEquals(date);

    }

    @Override
    public void deleteMovieById(int id) {
        Optional<MovieModel> movieModel = movieDao.findById(id);
        if(movieModel.isEmpty()){
            throw new MovieNotFoundException(id);
        }
        movieDao.deleteById(id);
    }
}
