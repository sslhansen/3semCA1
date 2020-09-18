package rest;

import DTO.JokeDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Joke;
import facades.JokeFacade;
import utils.EMF_Creator;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("joke")
public class JokeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final JokeFacade FACADE = JokeFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMembers() {
        List<JokeDTO> joke = FACADE.getAllJokes();
        return GSON.toJson(joke);
    }

    @Path("populate")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String populate() {
        FACADE.populate();
        return "added entries to db";
    }
    
    @Path("random")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRandomJoke(){
        JokeDTO joke = FACADE.getRandomJoke();
        return GSON.toJson(joke);
    }
    
    @Path("id/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getJokeById(@PathParam("id")Long id){
        JokeDTO joke = FACADE.getJokeById(id);
        return GSON.toJson(joke);
    }
}
