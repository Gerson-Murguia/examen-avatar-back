package avatar.global.examen_backend.controller;

import avatar.global.examen_backend.models.Film;
import avatar.global.examen_backend.models.FilmCharacter;
import avatar.global.examen_backend.service.FilmsConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin("http://localhost:4200")
public class FilmsController {

    private final FilmsConsumerService filmsConsumerService;

    @GetMapping("/film")
    public ResponseEntity<List<Film>> films() {
        System.out.println("Peticion a films");
        return ResponseEntity.ok( filmsConsumerService.getFilms().getResults());
    }

    @GetMapping("/film/{id}")
    public ResponseEntity <Film> filmById(@PathVariable int id) {
        System.out.println("Peticion a films");
        return ResponseEntity.ok( filmsConsumerService.getFilmById(id));
    }
    @GetMapping("/film/{id}/characters")
    public ResponseEntity <List<FilmCharacter>> charactersOfFilmById(@PathVariable int id) {
        System.out.println("Peticion a film characters");
        return ResponseEntity.ok( filmsConsumerService.getAllCharactersOfFilmById(id));
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

}
