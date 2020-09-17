package facades;

import DTO.CarDTO;
import entities.Car;
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

public class CarFacadeTest {
    private static EntityManagerFactory emf;
    private static CarFacade facade;
    private static Car r1, r2, r3;

    public CarFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = CarFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
        
    }
    
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        r1 = new Car(1995, "Volvo", "model1", 100, "Jens");
        r2 = new Car(1950, "Toyota", "model2", 120, "Hans");
        r3 = new Car(2001, "Audi", "model3", 140, "Henrik");
        em.getTransaction().commit();

        try {
            em.getTransaction().begin();

            em.createNamedQuery("Car.deleteAllRows").executeUpdate();
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
    }

    @Test
    public void testGetAllCars() {
        List<CarDTO> testGetAllCars = facade.getAllCars();
        assertEquals(testGetAllCars.size(), 3);
    }
    
}
