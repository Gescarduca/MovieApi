package guilherme.escarduca.MovieApi.Exceptions;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@NoArgsConstructor
public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(int id){super("Movie not found: " + id);}
}
