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

@Path("groupmembers")
public class GroupMemberResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

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
    public String getGroupMemberCount() {
        long count = FACADE.getGroupMemberCount();
        return "{\"count\":" + count + "}";
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
        return "added entries to db";
    }
}
