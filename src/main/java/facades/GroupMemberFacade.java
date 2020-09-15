package facades;

import entities.GroupMember;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class GroupMemberFacade {

    private static GroupMemberFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private GroupMemberFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static GroupMemberFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GroupMemberFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //TODO Remove/Change this before use
    public long getGroupMemberCount() {
        EntityManager em = getEntityManager();
        try {
            long renameMeCount = (long) em.createQuery("SELECT COUNT(r) FROM GroupMember r").getSingleResult();
            return renameMeCount;
        } finally {
            em.close();
        }
    }

    public List<GroupMember> getAllGroupMembers() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<GroupMember> query = em.createNamedQuery("GroupMember.getAllMembers", GroupMember.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void populate() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(new GroupMember("cph-test1", "test1", "test-tv-serie1"));
            em.persist(new GroupMember("cph-test2", "test2", "test-tv-serie2"));
            em.persist(new GroupMember("cph-test3", "test3", "test-tv-serie3"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

}
