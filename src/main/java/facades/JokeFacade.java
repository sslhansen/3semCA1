package facades;

import DTO.JokeDTO;
import entities.GroupMember;
import entities.Joke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private JokeFacade() {
    }

    public static JokeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<JokeDTO> getAllJokes() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.flush();
            em.getTransaction().commit();
            TypedQuery<Joke> query = em.createNamedQuery("Joke.getAllJokes", Joke.class);
            ArrayList<JokeDTO> res = new ArrayList();
            for (Joke e : query.getResultList()) {
                res.add(new JokeDTO(e));
            }
            return res;
        } finally {
            em.close();
        }
    }

    public JokeDTO getJokeById(long ID) {
        EntityManager em = getEntityManager();
        try {
            Joke result = em.find(Joke.class, ID);
            JokeDTO resultDTO = new JokeDTO(result);
            return resultDTO;
        } finally {
            em.close();
        }
    }
    public void populate() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new Joke("The cattle population is being affected by the pandemic", "They have cowronavirus"));
            em.persist(new Joke("Whats is the fastest growing country by population", "Ireland, It's Dublin every year"));
            em.persist(new Joke("My town's population never changes","Every time a girl gets pregnant, a guy leaves town"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    public JokeDTO getRandomJoke() {
        EntityManager em = getEntityManager();
        Random rand = new Random();
        try {
            TypedQuery<Joke> query = em.createNamedQuery("Joke.getAllJokes", Joke.class);
            List<Joke> resList = query.getResultList();
            int boundry = rand.nextInt(resList.size());
            Joke result = resList.get(boundry);
            JokeDTO resultDTO = new JokeDTO(result);
            return resultDTO;
        } finally {
            em.close();
        }
    }
}
