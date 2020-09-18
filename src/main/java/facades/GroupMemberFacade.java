package facades;

import entities.GroupMember;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class GroupMemberFacade {

    private static GroupMemberFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private GroupMemberFacade() {
    }

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
            em.getTransaction().begin();
            em.flush();
            em.getTransaction().commit();
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
            em.persist(new GroupMember("cph-mi93", "Michael Christian Ibsen", "Sex and the City S2"));
            em.persist(new GroupMember("cph-rg86", "Rasmus Grønbæk", "Hannah Montanna"));
            em.persist(new GroupMember("cph-sb287", "Sebastian James Bentley", "Vampire Diaries"));
            em.persist(new GroupMember("cph-sh499", "Sebastian Steen-Lundby Hansen", "Teen Wolf"));
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

}
