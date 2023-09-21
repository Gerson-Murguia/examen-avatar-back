package avatar.global.examen_backend.controller;

import avatar.global.examen_backend.models.FilmsResponse;
import avatar.global.examen_backend.service.FilmsConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@CrossOrigin("http://localhost:4200")
public class FilmsController {

    private final FilmsConsumerService filmsConsumerService;

    @GetMapping("/films")
    public ResponseEntity<FilmsResponse> films() {

        return ResponseEntity.ok( filmsConsumerService.getFilms());
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello world";
    }

}
