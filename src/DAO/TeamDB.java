/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.TeamModel;

/**
 *
 * @author fabri
 */
public class TeamDB {
    public void addTeamDB(TeamModel team) throws SQLException, Exception {
        String sql = "INSERT INTO teams (champ_id, name) values (?, ?);";
        Connection connection;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionBD().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, team.getChampId());
            stmt.setString(2, team.getName());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Created with success");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error to connect in DB");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in close stmt");
            }
        }
    }
        
    public ArrayList<TeamModel> listTeamDB(int champId) throws SQLException {
        String query = "SELECT * FROM teams WHERE champ_id=?;";        
        Connection connection;
        PreparedStatement stmt = null;
        

        connection = new ConnectionBD().conectorBD();
        stmt = connection.prepareStatement(query);
        stmt.setInt(1, champId);
        ResultSet rs = stmt.executeQuery();
        
        ArrayList<TeamModel> list = new ArrayList<>();
        
        if (rs != null) {
            while(rs.next()) {
                TeamModel team = new TeamModel(
                                                rs.getInt("champ_id"), 
                                                rs.getString("name"), 
                                                rs.getInt("id")
                                                );
                
                list.add(team);
            }
        }
        
        stmt.close();
        connection.close();
        
        return list;
    }
    
    public void editTeamDB(TeamModel team) throws SQLException, Exception {
        String sql = "UPDATE teams set name=? WHERE id=? and champ_id=?;";
        Connection connection;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionBD().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, team.getName());
            stmt.setInt(2, team.getId());
            stmt.setInt(3, team.getChampId());
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Edited with success");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error to connect in DB");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in close stmt");
            }
        }
    }
    
    public void deleteTeamDB(int champId, int id) throws SQLException, Exception {
        String sql = "DELETE FROM teams WHERE id=? and champ_id=?;";
        Connection connection;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionBD().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, champId);
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Deleted with success");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error to connect in DB");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error in close stmt");
            }
        }
    }
}
