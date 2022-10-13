package guilherme.escarduca.MovieApi.Controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import guilherme.escarduca.MovieApi.Models.MovieModel;
import guilherme.escarduca.MovieApi.Models.MovieModel;
import guilherme.escarduca.MovieApi.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    //getMovie
    @GetMapping("/{id}")
    public RepresentationModel<MovieModel> getMovie(@PathVariable("id") int id){
        MovieModel movie = movieService.findMovieById(id);
        movie.add(linkTo(MovieController.class).slash((movie.getId())).withSelfRel());
        return movie;
    };
    //createMovie
    @PostMapping()
    public RepresentationModel<MovieModel> createMovie(@Valid @RequestBody MovieModel movieModel) throws JsonProcessingException {
        MovieModel movieResponse = movieService.save(movieModel);
        movieResponse.add(linkTo(MovieController.class).slash((movieModel.getId())).withSelfRel());
        return movieResponse;
    };
    //saveOrUpdateMovie
    @PutMapping("/{id}")
    public RepresentationModel<MovieModel> updateMovie(@Valid @RequestBody MovieModel movieModel, @PathVariable("id") int id) throws JsonProcessingException {
        MovieModel movieResponse = movieService.update(movieModel,id);
        movieResponse.add(linkTo(MovieController.class).slash(movieModel.getId()).withSelfRel());
        return movieResponse;
    };

    //deleteMovie
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") int id){
        movieService.deleteMovieById(id);
    };


    //getMoviesByLauchDate
    @GetMapping()
    public CollectionModel<MovieModel> getAllMovies(){
        return CollectionModel.of(movieService.getMovies().stream()
                .map(movieModel -> movieModel.add(linkTo(MovieController.class).slash(movieModel.getId()).withSelfRel()))
                .collect(Collectors.toList()), linkTo(MovieController.class).withSelfRel());
    };

    @GetMapping("/byDate/{launchDate}")
    public CollectionModel<MovieModel> getMoviesBydLaunchDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate launchDate){
         return CollectionModel.of(movieService.getMoviesByLaunchDate(launchDate).stream()
                 .map(movieModel -> movieModel.add(linkTo(MovieController.class).slash(movieModel.getId()).withSelfRel()))
                 .collect(Collectors.toList()), linkTo(MovieController.class).withSelfRel());
    };

}
