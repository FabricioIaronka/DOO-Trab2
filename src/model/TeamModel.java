/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fabri
 */
public class TeamModel {
    private int id;
    private int champId;
    private String name;

    public TeamModel(int champId, String nome) {
        this.champId = champId;
        this.name = nome;
    }
    
    public TeamModel(int champId, String name, int id) {
        this.champId = champId;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getChampId() {
        return champId;
    }
        
}
