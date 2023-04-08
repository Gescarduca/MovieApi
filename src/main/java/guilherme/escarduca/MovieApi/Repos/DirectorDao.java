package guilherme.escarduca.MovieApi.Repos;

import guilherme.escarduca.MovieApi.Models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorDao extends JpaRepository<Director,Integer> {


    public boolean existsByName(String DirectorName);

    public Optional<Director> findByName(String name);


}
