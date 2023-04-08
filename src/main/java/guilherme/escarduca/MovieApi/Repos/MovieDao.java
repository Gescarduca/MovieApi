package guilherme.escarduca.MovieApi.Repos;

import guilherme.escarduca.MovieApi.Models.MovieEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieDao extends CrudRepository<MovieEntity, Integer> {
    Optional<MovieEntity> findById(int id);
    List<MovieEntity> findAll();
    List<MovieEntity> findByLaunchDateEquals(LocalDate launchDate);
    @Query("Select max(id) from MovieEntity")
    int getMaxId();
}
