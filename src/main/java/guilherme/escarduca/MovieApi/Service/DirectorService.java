package guilherme.escarduca.MovieApi.Service;

import guilherme.escarduca.MovieApi.Models.Director;

import java.util.Collection;

public interface DirectorService {
    public Director create(Director director);

    public Director update(Director director, int id);

    public Director findById(int id);

    public void deleteDirector(int id);

    public Collection<Director> findAllDirectors();

    public void deleteDirectorDetail(int id);
}
