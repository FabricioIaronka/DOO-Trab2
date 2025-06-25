/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fabri
 */
public class DriverModel extends ParticipantModel{
    

    public DriverModel(int champId, int teamId, int id, String nome, int licenseLvl, int experienceHrs) {
        super(champId, teamId, id, nome,licenseLvl, experienceHrs);
    }
    
    public DriverModel(int champId, int teamId, String name, int licenseLvl, int experienceHrs) {
        super(champId, teamId, name, licenseLvl, experienceHrs);
    }

    
    
    
}
