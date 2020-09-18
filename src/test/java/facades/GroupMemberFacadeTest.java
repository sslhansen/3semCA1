package facades;

import utils.EMF_Creator;
import entities.GroupMember;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class GroupMemberFacadeTest {

    private static EntityManagerFactory emf;
    private static GroupMemberFacade facade;

    public GroupMemberFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = GroupMemberFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("GroupMember.deleteAllRows").executeUpdate();
            em.persist(new GroupMember("cph-test1", "test1", "test-tv-serie1"));
            em.persist(new GroupMember("cph-test2", "test2", "test-tv-serie2"));
            em.persist(new GroupMember("cph-test3", "test3", "test-tv-serie3"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testGetMovieCount() {
        assertEquals(3, facade.getGroupMemberCount(), "Expects three rows in the database");
    }

    @Test
    public void testGetAllGroupMembers() {
        List<GroupMember> groupMembers = facade.getAllGroupMembers();
        List<GroupMember> groupMembersExpected = new ArrayList();
        groupMembersExpected.add(new GroupMember("cph-test1", "test1", "test-tv-serie1"));
        groupMembersExpected.add(new GroupMember("cph-test2", "test2", "test-tv-serie2"));
        groupMembersExpected.add(new GroupMember("cph-test3", "test3", "test-tv-serie3"));
        assertEquals(groupMembers.size(), groupMembersExpected.size());
    }

    @Test
    public void testPopulate() {
        int sizeBefore = facade.getAllGroupMembers().size();
        facade.populate();
        int sizeNow = facade.getAllGroupMembers().size();
        assertEquals((sizeBefore + 4), sizeNow);
    }

}
