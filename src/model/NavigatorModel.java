/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fabri
 */
public class NavigatorModel extends ParticipantModel{
    private int licenseLvl;
    private int experienceHrs;
    private boolean haveEquipment;

    public NavigatorModel(int champId, int teamId, int id, String name, int licenseLvl, int experienceHrs, boolean haveEquipment) {
        super(champId, teamId, id, name, licenseLvl, experienceHrs);
        this.haveEquipment = haveEquipment;
    }
    
    public NavigatorModel(int champId, int teamId, String nome, int licenseLvl, int experienceHrs, boolean haveEquipment) {
        super(champId, teamId, nome, licenseLvl, experienceHrs);
        
        this.haveEquipment = haveEquipment;
    }

    public int getLicenseLvl() {
        return licenseLvl;
    }

    public int getExperienceHrs() {
        return experienceHrs;
    }

    public boolean haveEquipment() {
        return haveEquipment;
    }
    
    
}
