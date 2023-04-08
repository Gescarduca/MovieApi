package guilherme.escarduca.MovieApi.Aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //need to find out why it cannot resolve this class but can work with void methods and can compile
    //logging method to be called before the method execution on any getMovieById method
    @Before("execution(public guilherme.escarduca.MovieApi.Models.MovieModel getMovieById(int))")
    public void logBeforeGetMovie(){
        System.out.println("Before getMovieById method");
    }

    @Before("execution(public void deleteMovieById(int))")
    public void logBeforeDeleteMovie(){
        System.out.println("Before deleteMovieById method");
    }
}
