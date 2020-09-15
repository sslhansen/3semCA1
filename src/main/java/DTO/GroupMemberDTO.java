/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.GroupMember;

/**
 *
 * @author Sebastian
 */
public class GroupMemberDTO {

    private String studentID;
    private String name;
    private String FavoriteTVSeries;

    public GroupMemberDTO(GroupMember gm) {
        this.studentID = gm.getStudentID();
        this.name = gm.getName();
        this.FavoriteTVSeries = gm.getFavoriteTVSeries();
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

}