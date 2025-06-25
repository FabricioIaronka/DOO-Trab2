/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author fabri
 */
public class ChampionshipModel {
    private int id;
    private String name;
    private int year;

    public ChampionshipModel(String name, int year) {
        this.name = name;
        this.year = year;
    }
    
    public ChampionshipModel(int id, String nome, int year) {
        this.id = id;
        this.name = nome;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return id + " - " + name ;
    }
    
}
