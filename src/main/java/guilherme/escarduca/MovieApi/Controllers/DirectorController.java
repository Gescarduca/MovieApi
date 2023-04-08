package guilherme.escarduca.MovieApi.Controllers;

import guilherme.escarduca.MovieApi.Models.Director;
import guilherme.escarduca.MovieApi.Models.DirectorModel;
import guilherme.escarduca.MovieApi.Service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies/director")
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @GetMapping("/{id}")
    public Director getDirector(@PathVariable("id") int id){
        Director director = directorService.findById(id);
        return director;
    }

    @PostMapping()
    public Director createDirector(@RequestBody Director director){
        return directorService.create(director);

    }

    @PutMapping("/{id}")
    public Director updateDirector(@Valid @RequestBody Director director, @PathVariable("id")Integer id){
        return directorService.update(director,id);
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable("id") Integer id){
        directorService.deleteDirector(id);
    }
//
    @GetMapping("/all")
    public Collection<Director> getAllDirectors(){
        return directorService.findAllDirectors();
    }
//
//    @DeleteMapping("/director-detail/{id}")
//    public void deleteDirectorDetail(@PathVariable("id") int id){
//        System.out.println("in controller");
//        directorService.deleteDirectorDetail(id);
//
//    }
}
