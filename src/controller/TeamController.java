/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.ChampionshipDB;
import DAO.TeamDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TeamModel;

/**
 *
 * @author fabri
 */
public class TeamController {
    TeamDB teamDB;
    
    public TeamController() {
        this.teamDB = new TeamDB();
    }
    
    public void create(int champId, String name) throws SQLException, Exception{
        if(isValuesValid(name)){
            TeamModel teamM = new TeamModel(champId, name);
            
            this.teamDB.addTeamDB(teamM);
        }
        else{
            throw new IOException("Name invalid");
        }
        
    }
    
    public ArrayList<TeamModel> list(int champId) throws SQLException{
        return this.teamDB.listTeamDB(champId);
    }
    
    public void edit(int champId, String name, int id )throws SQLException, Exception{
        if(isValuesValid(name)){
            TeamModel teamM = new TeamModel(champId, name, id);
            
            this.teamDB.editTeamDB(teamM);
        }
        else{
            throw new IOException("Name invalid");
        }
    }
    
    public void delete(int champId, int id) throws SQLException, Exception{
        this.teamDB.deleteTeamDB(champId, id);
        
    }
    
    private boolean isValuesValid(String name) {
        return name != null && name.length() <=50;
       
    }
}
