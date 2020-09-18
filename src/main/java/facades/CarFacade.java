package facades;

import DTO.CarDTO;
import DTO.JokeDTO;
import entities.Car;
import entities.Joke;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class CarFacade {

    private static CarFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CarFacade() {
    }

    public static CarFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<CarDTO> getAllCars() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.flush();
            em.getTransaction().commit();
            TypedQuery<CarDTO> query = em.createNamedQuery("Car.getAllCars", CarDTO.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void populate() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Car(1997, "Ford", "E350", 3000, "John"));
            em.persist(new Car(1999, "Chevy", "Venture", 4900, "Michael"));
            em.persist(new Car(2000, "Chevy", "Venture", 5000, "Terkel"));
            em.persist(new Car(1996, "Jeep", "Grand Cherokee", 4799, "Svend"));
            em.persist(new Car(2005, "Volvo", "V70", 44799, "Svend-Bo"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

}
