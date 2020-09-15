package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "GroupMember.deleteAllRows", query = "DELETE from GroupMember"),
@NamedQuery(name = "GroupMember.getAllMembers", query = "SELECT e from GroupMember e")
})
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentID;
    private String name;
    private String favoriteTVSeries;

    public GroupMember(String studentID, String name, String favoriteTVSeries) {
        this.studentID = studentID;
        this.name = name;
        this.favoriteTVSeries = favoriteTVSeries;
    }

    public GroupMember() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteTVSeries() {
        return favoriteTVSeries;
    }

    public void setFavoriteTVSeries(String FavoriteTVSeries) {
        this.favoriteTVSeries = FavoriteTVSeries;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
}
