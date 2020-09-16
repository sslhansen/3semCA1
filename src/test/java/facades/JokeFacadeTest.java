/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.JokeDTO;
import entities.GroupMember;
import entities.Joke;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import utils.EMF_Creator;

/**
 *
 * @author Mibsen
 */
public class JokeFacadeTest {

    private static EntityManagerFactory emf;
    private static JokeFacade facade;
    private static Joke r1, r2, r3;

    public JokeFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = JokeFacade.getFacadeExample(emf);
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
        em.getTransaction().begin();
        r1 = new Joke("Wanna hear a joke?", "Me");
        r2 = new Joke("Wanna hear another?", "Multimediedesigner");
        r3 = new Joke("One last joke", "KEA");
        em.getTransaction().commit();

        try {
            em.getTransaction().begin();

            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            em.persist(r1);
            em.persist(r2);
            em.persist(r3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    @Test
    public void testGetAllJokes() {
        List<JokeDTO> testGetAllJokes = facade.getAllJokes();
        assertEquals(testGetAllJokes.size(), 3);
    }

    @Test
    public void testGetJokeById() {
        JokeDTO joke = facade.getJokeById(r1.getId());
        assertEquals("Me", joke.getType());
    }

    @Test
    public void testGetRandomJoke() {
        JokeDTO joke = facade.getRandomJoke();
        assertTrue(joke.getType().equals("Me") || joke.getType().equals("Multimediedesigner") || joke.getType().equals("KEA"));
    }
}
