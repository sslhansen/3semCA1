package rest;

import DTO.GroupMemberDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.GroupMember;
import utils.EMF_Creator;
import facades.GroupMemberFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("groupmembers")
public class GroupMemberResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    //An alternative way to get the EntityManagerFactory, whithout having to type the details all over the code
    //EMF = EMF_Creator.createEntityManagerFactory(DbSelector.DEV, Strategy.CREATE);
    private static final GroupMemberFacade FACADE = GroupMemberFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {
        long count = FACADE.getRenameMeCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMembers() {
        List<GroupMemberDTO> groupMembersDTO = new ArrayList();
        List<GroupMember> groupMembers = FACADE.getAllGroupMembers();
        for (GroupMember gm : groupMembers) {
            groupMembersDTO.add(new GroupMemberDTO(gm));
        }
        return GSON.toJson(groupMembersDTO);
    }

    @Path("populate")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String populate() {
        FACADE.populate();
        //System.out.println("--------------->"+count);
        return "added entries to db";  //Done manually so no need for a DTO
    }
}
