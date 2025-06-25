/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fabri
 */
public class ParticipantModel {
    private String name;
    private int id;
    private int teamId;
    private int champId;
    private int licenseLvl;
    private int experienceHrs;

    public ParticipantModel(int champId, int teamId, int id , String name, int licenseLvl, int experienceHrs) {
        this.name = name;
        this.id = id;
        this.teamId = teamId;
        this.champId = champId;
        this.licenseLvl = licenseLvl;
        this.experienceHrs = experienceHrs;
    }
    
    public ParticipantModel(int champId, int teamId, String name, int licenseLvl, int experienceHrs) {
        this.name = name;
        this.teamId = teamId;
        this.champId = champId;
        this.licenseLvl = licenseLvl;
        this.experienceHrs = experienceHrs;
    }
    

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getChampId() {
        return champId;
    }    

    public int getLicenseLvl() {
        return licenseLvl;
    }

    public int getExperienceHrs() {
        return experienceHrs;
    }
    
    
    
}
