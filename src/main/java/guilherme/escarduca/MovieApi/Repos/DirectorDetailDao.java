package guilherme.escarduca.MovieApi.Repos;

import guilherme.escarduca.MovieApi.Models.DirectorDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorDetailDao extends JpaRepository<DirectorDetail,Integer> {
}
