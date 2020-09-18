package rest;

import DTO.CarDTO;
import DTO.JokeDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facades.CarFacade;
import facades.JokeFacade;
import utils.EMF_Creator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("car")
public class CarResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final CarFacade FACADE = CarFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCars() {
        List<CarDTO> car = FACADE.getAllCars();
        return GSON.toJson(car);
    }

    @Path("populate")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String populate() {
        FACADE.populate();
        return "added entries to db";
    }
}
