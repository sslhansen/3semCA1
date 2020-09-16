package DTO;

import entities.Joke;

public class JokeDTO {
    
    private Long id;
    private String jokeLine;
    private String type;

    public JokeDTO(Joke joke) {
        this.id = joke.getId();
        this.jokeLine = joke.getJokeLine();
        this.type = joke.getType();
    }

    public JokeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJokeLine() {
        return jokeLine;
    }

    public void setJokeLine(String jokeLine) {
        this.jokeLine = jokeLine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
