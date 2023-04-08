package guilherme.escarduca.MovieApi.Enums;

public enum DirectorExceptions {
    DirectorNotFound("Director was not found"),
    DirectorAlreadyExists("Director already exists");

    private final String message;

    DirectorExceptions(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
