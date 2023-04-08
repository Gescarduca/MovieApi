package guilherme.escarduca.MovieApi.Service;

import guilherme.escarduca.MovieApi.Exceptions.DirectorException;
import guilherme.escarduca.MovieApi.Models.Director;
import guilherme.escarduca.MovieApi.Repos.DirectorDao;
import guilherme.escarduca.MovieApi.Repos.DirectorDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Transactional
public class DirectorServiceImp implements DirectorService{

    @Autowired
    private DirectorDao directorDao;

    @Autowired
    private DirectorDetailDao directorDetailDao;
    @Override
    public Director findById(int id) {
        Optional<Director> director1 = directorDao.findById(id);
        System.out.println(director1.get());
        return director1.orElseThrow(DirectorException::directorExceptionNotFound);
    }

    @Override
    public Director create(Director director) {
        if (directorDao.existsByName(director.getName())){
            DirectorException.directorAlreadyExists();
        }
        return directorDao.save(director);
    }

    @Override
    public Director update(Director director, int id) {
        if (!directorDao.existsById(id)){
            DirectorException.directorExceptionNotFound();
        }
        return directorDao.save(director);
    }

    @Override
    public void deleteDirector(int id) {
        if (!directorDao.existsById(id)){
            DirectorException.directorExceptionNotFound();
        }
        directorDao.deleteById(id);
    }

    @Override
    public Collection<Director> findAllDirectors(){
        return directorDao.findAll();
    }

    @Override
    public void deleteDirectorDetail(int id){
        if (directorDetailDao.existsById(id)){
            directorDetailDao.deleteById(id);
            System.out.println("Inside delete director detail");
        }
    };

}
