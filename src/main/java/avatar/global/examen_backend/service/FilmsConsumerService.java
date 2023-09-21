package avatar.global.examen_backend.service;

import avatar.global.examen_backend.models.Films;
import avatar.global.examen_backend.models.FilmsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

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

}
