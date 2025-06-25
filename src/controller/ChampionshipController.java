/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.ChampionshipModel;
import DAO.ChampionshipDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fabri
 */
public class ChampionshipController {
    private ChampionshipDB champDB;

    public ChampionshipController() {
        this.champDB = new ChampionshipDB();
    }
    
    public void createChampioship(String name, int year) throws SQLException, Exception{
        if(isValuesValid(name, year)){
            ChampionshipModel champM = new ChampionshipModel(name, year);
            
            System.out.println("Controller");
            this.champDB.addChampDB(champM);
        }
        else{
            System.out.println("Error name or year");
        }
        
    }
    
    public ArrayList<ChampionshipModel> listChampioship() throws SQLException{
        return this.champDB.listChampDB();
    }
    
    public boolean isValuesValid(String name, int year) {
        boolean isName = name != null && name.length() <=50;
        boolean isYear = year > 0;
        
        return isName && isYear;
       
    }
    
    public void editChampionship(int id, String name, int year) throws SQLException, Exception{
        if(isValuesValid(name, year)){
            ChampionshipModel champM = new ChampionshipModel(id, name, year);
            
            System.out.println("Controller");
            this.champDB.editChampDB(champM);
        }
        else{
            System.out.println("Error name or year");
        }
    }
    
    public void deleteChampionship(int id, String name, int year) throws SQLException, Exception{
        if(isValuesValid(name, year)){
            ChampionshipModel champM = new ChampionshipModel(id, name, year);
            
            System.out.println("Controller");
            this.champDB.deleteChampDB(champM);
        }
        else{
            throw new IOException("Name or year invalid");
        }
    }
    
}
