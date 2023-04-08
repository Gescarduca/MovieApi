package guilherme.escarduca.MovieApi.Controllers;

import guilherme.escarduca.MovieApi.Models.MovieV1;
import guilherme.escarduca.MovieApi.Models.MovieV2;
import guilherme.escarduca.MovieApi.Models.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class VersioningMovieController {

    //url versioning
    @GetMapping("v1/movie")
    public MovieV1 getFirstVersionOfMovie(){
        return new MovieV1("Titanic","drama");
    }

    //url versioning
    @GetMapping("v2/movie")
    public MovieV2 getSecondVersionOfMovie(){
        return new MovieV2(new Name("Bob","Charlie"));
    }

    //request parameter versioning
    @GetMapping(value = "movie", params = "version=1")
    public MovieV1 getFirstVersionOfMovieParameterVersioning(){
        return new MovieV1("Titanic","drama");
    }

    //request parameter versioning
    @GetMapping(value = "movie", params = "version=2")
    public MovieV2 getSecondVersionOfMovieParameterVersioning(){
        return new MovieV2(new Name("Bob","Charlie"));
    }

    //Custom Headers Versioning
    @GetMapping(value = "movie/headers", headers = "X-API-VERSION=1")
    public MovieV1 getFirstMovieVersionRequestHeader(){
        return new MovieV1("Titanic","drama");
    }

    //Custom Headers Versioning, in postman, the header to add woud be X-API-VERSION and the value would be 2
    @GetMapping(value = "movie/versions", headers = "X-API-VERSION=2")
    public MovieV2 getSecondMovieVersionRequestHeader(){
        return new MovieV2(new Name("Bob","Charlie"));
    }


    @GetMapping(value = "movie/versions", produces = "application/movie.mediaType.versioning")
    public MovieV1 getFirstMovieVersionMediaType1(){
        return new MovieV1("Titanic","drama");
    }

    @GetMapping(value = "movie/versions", produces = "application/movie.mediaType.versioning-2")
    public MovieV2 getFirstMovieVersionMediaType2(){
        return new MovieV2(new Name("Bob","Charlie"));
    }
}
