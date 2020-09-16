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
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mibsen
 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private JokeFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
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

    public Joke getJokeById(long ID) {
        EntityManager em = getEntityManager();
        try {
            Joke result = em.find(Joke.class, ID);
            return result;
        } finally {
            em.close();
        }
    }

    public Joke getRandomJoke() {
        EntityManager em = getEntityManager();
        Random rand = new Random();
        try {
            TypedQuery<Joke> query = em.createNamedQuery("Joke.getAllJokes", Joke.class);
            List<Joke> resList = query.getResultList();
            int boundry = rand.nextInt(resList.size());
            
            return resList.get(boundry);
        } finally {
            em.close();
        }
    }
}
