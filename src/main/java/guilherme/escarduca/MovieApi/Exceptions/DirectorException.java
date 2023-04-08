package guilherme.escarduca.MovieApi.Exceptions;

import guilherme.escarduca.MovieApi.Enums.DirectorExceptions;

public class DirectorException extends RuntimeException{

    public DirectorException(String message) {
        super(message);
    }

    public static DirectorException directorExceptionNotFound(){
        return new DirectorException(DirectorExceptions.DirectorNotFound.getMessage());
    }

    public static DirectorException directorAlreadyExists(){
        return new DirectorException(DirectorExceptions.DirectorAlreadyExists.getMessage());
    }


}
