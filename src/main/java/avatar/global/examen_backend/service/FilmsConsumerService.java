package avatar.global.examen_backend.service;

import avatar.global.examen_backend.models.Film;
import avatar.global.examen_backend.models.FilmsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmsConsumerService {
    private final RestTemplate restTemplate;

    public FilmsResponse getFilms(){
        String filmsURL = "https://swapi.dev/api/films/";
        ResponseEntity<FilmsResponse> filmsResponseEntity = restTemplate.exchange(filmsURL,
                HttpMethod.GET,
                null,
                FilmsResponse.class);
        return filmsResponseEntity.getBody();
    }

    public Film getFilmById(int filmId) {
        Optional<Film> film = getFilms().getResults().stream().filter(films -> films.getEpisodeId()==filmId).findFirst();
        if (film.isPresent()){
            return film.get();
        }else{
            System.out.println("Film not found");
            return null;
        }
    }
}
