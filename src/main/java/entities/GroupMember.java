package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "RenameMe.deleteAllRows", query = "DELETE from RenameMe")
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentID;
    private String name;
    private String FavoriteTVSeries;

    public GroupMember(String studentID, String name, String FavoriteTVSeries) {
        this.studentID = studentID;
        this.name = name;
        this.FavoriteTVSeries = FavoriteTVSeries;
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
        return FavoriteTVSeries;
    }

    public void setFavoriteTVSeries(String FavoriteTVSeries) {
        this.FavoriteTVSeries = FavoriteTVSeries;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }   
}
