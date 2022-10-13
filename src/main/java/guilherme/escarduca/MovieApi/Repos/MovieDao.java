package guilherme.escarduca.MovieApi.Repos;

import guilherme.escarduca.MovieApi.Models.MovieModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieDao extends CrudRepository<MovieModel, Integer> {
    Optional<MovieModel> findById(int id);
    List<MovieModel> findAll();
    List<MovieModel> findByLaunchDateEquals(LocalDate launchDate);
    @Query("Select max(id) from MovieModel")
    int getMaxId();
}
