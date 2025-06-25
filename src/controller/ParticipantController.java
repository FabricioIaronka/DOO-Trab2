/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ParticipantDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DriverModel;
import model.NavigatorModel;
import model.ParticipantModel;

/**
 *
 * @author fabri
 */
public class ParticipantController {
    ParticipantDB partDB;
    
    public ParticipantController() {
        this.partDB = new ParticipantDB();
    }
    
    // Create participant of type navigator
    public void create(int champId, int teamId, String name, int licenseLvl, int experienceHrs, boolean haveEquipment) throws SQLException, Exception{
        if(isValuesValid(name, licenseLvl, experienceHrs)){
            ParticipantModel partM = new NavigatorModel(champId, teamId, name, licenseLvl, experienceHrs, haveEquipment);
            this.partDB.addParticipantDB(partM);
        }
        else{
            throw new IOException("Name, lvl or experience invalid");
        } 
    }
    
    // Create participant of type driver
    public void create(int champId, int teamId, String name, int licenseLvl, int experienceHrs) throws SQLException, Exception{
        if(isValuesValid(name, licenseLvl, experienceHrs)){
            ParticipantModel partM = new DriverModel(champId, teamId, name, licenseLvl, experienceHrs);
            System.out.println("Adding");
            this.partDB.addParticipantDB(partM);
            
        }
        else{
            throw new IOException("Name, lvl or experience invalid");
        } 
    }
    
    public ArrayList<ParticipantModel> list(int champId) throws SQLException{
        System.out.println("Listing"+champId);
        return this.partDB.listParticipantDB(champId);
    }
    
    // Create participant of type navigator
    public void edit(int champId, int teamId, int id, String name, int licenseLvl, int experienceHrs, boolean haveEquipment) throws SQLException, Exception{
        if(isValuesValid(name, licenseLvl, experienceHrs)){
            ParticipantModel teamM = new NavigatorModel(champId, teamId, id, name, licenseLvl, experienceHrs, haveEquipment);
            this.partDB.editParticipantDB(teamM);
        }
        else{
            throw new IOException("Name invalid");
        }
    }
    
    // Create participant of type driver
    public void edit(int champId, int teamId, int id, String name, int licenseLvl, int experienceHrs) throws SQLException, Exception{
        if(isValuesValid(name, licenseLvl, experienceHrs)){
            ParticipantModel teamM = new DriverModel(champId, teamId, id, name, licenseLvl, experienceHrs);
            this.partDB.editParticipantDB(teamM);
        }
        else{
            throw new IOException("Name invalid");
        }
    }
    
    public void delete(int champId, int teamId, int id) throws SQLException, Exception{
        this.partDB.deleteParticipantDB(champId,teamId, id);
        
    }
    
    private boolean isValuesValid(String name, int licenseLvl, int experienceHrs) {
        boolean isName = name != null && name.length() <=50;
        boolean isLvl = licenseLvl >= 0;
        boolean isHrs = experienceHrs >= 0;
        
        return name != null && name.length() <=50;
       
    }
}
