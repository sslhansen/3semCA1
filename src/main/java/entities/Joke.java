/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Mibsen
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Joke.deleteAllRows", query = "DELETE from Joke"),
@NamedQuery(name = "Joke.getAllJokes", query = "SELECT e from Joke e")
})
public class Joke implements Serializable {
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jokeLine;
    private String type;
    

    public Joke() {
    }

    public Joke(String jokeLine, String type) {
        this.jokeLine = jokeLine;
        this.type = type;
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
