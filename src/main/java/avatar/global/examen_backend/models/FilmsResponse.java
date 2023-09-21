package avatar.global.examen_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class FilmsResponse {

    private int count;
    private int next;
    private int previous;
    @JsonProperty("results")
    private List<Film> results;
}
