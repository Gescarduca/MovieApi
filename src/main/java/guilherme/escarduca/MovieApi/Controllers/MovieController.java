package guilherme.escarduca.MovieApi.Controllers;


import guilherme.escarduca.MovieApi.Models.MovieModel;
import guilherme.escarduca.MovieApi.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    //Interface for resolving messages, supposts parameterization and internationalization of such messages
    @Autowired
    MessageSource messageSource;


    //getMovie
    @GetMapping("/{id}")
    public MovieModel getMovie(@PathVariable("id") int id){
        //MovieModel movie = movieService.findMovieById(id);
        MovieModel movieModel = movieService.findMovieById(id);
        movieModel
                .add(linkTo(MovieController.class).slash((movieModel.getId())).withSelfRel())
                .add(linkTo(this.getClass()).withRel("all-movies"));

        return movieModel;
    };
//    //createMovie
//    @PostMapping()
//    public RepresentationModel<MovieModel> createMovie(@Valid @RequestBody MovieModel movieModel,@RequestParam String DirectorName, BindingResult theBindingResult) {
//        System.out.println("Binding Result: "+ theBindingResult);
//        MovieModel movieResponse = movieService.save(movieModel);
//        movieResponse.add(linkTo(MovieController.class).slash((movieModel.getId())).withSelfRel());
//        return movieResponse;
//    };
//    //saveOrUpdateMovie
//    @PutMapping("/{id}")
//    public RepresentationModel<MovieModel> updateMovie(@Valid @RequestBody MovieModel movieModel, @PathVariable("id") int id) {
//        MovieModel movieResponse = movieService.update(movieModel,id);
//        movieResponse.add(linkTo(MovieController.class).slash(movieModel.getId()).withSelfRel());
//        return movieResponse;
//    };
//
//    //deleteMovie
//    @DeleteMapping("/{id}")
//    public void deleteMovie(@PathVariable("id") int id){
//        movieService.deleteMovieById(id);
//    };
//
//
//    //getMoviesByLauchDate
//    @GetMapping()
//    public CollectionModel<MovieModel> getAllMovies(){
//        return CollectionModel.of(movieService.getMovies().stream()
//                .map(movieModel -> movieModel.add(linkTo(MovieController.class).slash(movieModel.getId()).withSelfRel()))
//                .collect(Collectors.toList()), linkTo(MovieController.class).withSelfRel());
//    };
//
//    @GetMapping("/byDate/{launchDate}")
//    public CollectionModel<MovieModel> getMoviesBydLaunchDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate launchDate){
//         return CollectionModel.of(movieService.getMoviesByLaunchDate(launchDate).stream()
//                 .map(movieModel -> movieModel.add(linkTo(MovieController.class).slash(movieModel.getId()).withSelfRel()))
//                 .collect(Collectors.toList()), linkTo(MovieController.class).withSelfRel());
//    };
//
//
//    @GetMapping("/helloWorld")
//    public String internationalizationMovie(){
//        //this is an example of i18n, you define the required messages for the languages you wish to support and using by using messageSource and passing a language header on the request, you automatically choose
//        //which file to use
//        Locale locale = LocaleContextHolder.getLocale();//returns the locale
//        //first field is the variable name in messages.properties, second is if you have a variable to insert into the string,third is default message, fourth is locale the location of the request
//        return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
//
//    }
}
