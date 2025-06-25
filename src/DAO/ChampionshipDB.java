/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import model.ChampionshipModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.util.ArrayList;


/**
 *
 * @author fabri
 */
public class ChampionshipDB {
    public void addChampDB(ChampionshipModel champ) throws SQLException, Exception {
        String sql = "INSERT INTO championship (name, year) values (?, ?);";
        Connection connection;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionBD().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, champ.getName());
            stmt.setInt(2, champ.getYear());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos no banco com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao fechar o stmt");
            }
        }
    }
        
    public ArrayList<ChampionshipModel> listChampDB() throws SQLException {
        String query = "SELECT * FROM championship";        
        Connection connection;
        PreparedStatement stmt = null;
        

        connection = new ConnectionBD().conectorBD();
        stmt = connection.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<ChampionshipModel> list = new ArrayList<>();
        
        if (rs != null) {
            while(rs.next()) {
                ChampionshipModel champ = new ChampionshipModel(
                                                rs.getInt("id"), 
                                                rs.getString("name"), 
                                                rs.getInt("year")
                                                );
                
                list.add(champ);
            }
        }
        
        stmt.close();
        connection.close();
        
        return list;
    }
    
    public void editChampDB(ChampionshipModel champ) throws SQLException, Exception {
        String sql = "UPDATE championship set name=?, year=? WHERE id=?;";
        Connection connection;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionBD().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, champ.getName());
            stmt.setInt(2, champ.getYear());
            stmt.setInt(3, champ.getId());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Edited with success");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao fechar o stmt");
            }
        }
    }
    
    public void deleteChampDB(ChampionshipModel champ) throws SQLException, Exception {
        String sql = "DELETE FROM championship WHERE id=?;";
        Connection connection;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionBD().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, champ.getId());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Dados deletados no banco com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao fechar o stmt");
            }
        }
    }
        
    
}
