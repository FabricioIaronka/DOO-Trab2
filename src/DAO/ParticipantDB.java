/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.DriverModel;
import model.NavigatorModel;
import model.ParticipantModel;

/**
 *
 * @author fabri
 */
public class ParticipantDB {
    public void addParticipantDB(ParticipantModel part) throws SQLException, Exception {
        String sql = "INSERT INTO participant (champ_id, team_id, name, license_lvl, experience_hours) VALUES (?, ?, ?, ?, ?);";
        Connection connection;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionBD().conectorBD();
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, part.getChampId());
            stmt.setInt(2, part.getTeamId());
            stmt.setString(3, part.getName());
            stmt.setInt(4, part.getLicenseLvl());
            stmt.setInt(5, part.getExperienceHrs());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if (rs.next()) {
                int participantId = rs.getInt(1);
            
                if (part instanceof DriverModel) {
                    DriverModel d = (DriverModel) part;
                    PreparedStatement psDriver = connection.prepareStatement("INSERT INTO driver (participant_id) VALUES (?)");
                    psDriver.setInt(1, participantId);
                    psDriver.executeUpdate();
                } 
                else if (part instanceof NavigatorModel) {

                    NavigatorModel n = (NavigatorModel) part;
                    PreparedStatement psNav = connection.prepareStatement("INSERT INTO navigator (participant_id, have_equipment) VALUES (?, ?)");
                    psNav.setInt(1, participantId);
                    psNav.setBoolean(2, n.haveEquipment());
                    psNav.executeUpdate();
                }
            }
            
            
            
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
        
    public ArrayList<ParticipantModel> listParticipantDB(int champId) throws SQLException {
        String query = """
                        SELECT 
                            p.id,
                            p.name,
                            p.champ_id,
                            p.team_id,
                            p.license_lvl,
                            p.experience_hours,
                            CASE 
                                WHEN d.participant_id IS NOT NULL THEN 'Driver'
                                WHEN n.participant_id IS NOT NULL THEN 'Navigator'
                                ELSE 'Unknown'
                            END AS role,
                            n.have_equipment
                        FROM participant p
                        LEFT JOIN driver d ON p.id = d.participant_id
                        LEFT JOIN navigator n ON p.id = n.participant_id
                        WHERE p.champ_id = ?;
                    """;      
        
        Connection connection;
        PreparedStatement stmt = null;
        

        connection = new ConnectionBD().conectorBD();
        stmt = connection.prepareStatement(query);
        stmt.setInt(1, champId);
        ResultSet rs = stmt.executeQuery();
        ArrayList<ParticipantModel> list = new ArrayList<>();
        
        while (rs != null && rs.next()) {
            int id = rs.getInt("id");
            int teamId = rs.getInt("team_id");
            String name = rs.getString("name");
            int licenseLvl = rs.getInt("license_lvl");
            int experienceHrs = rs.getInt("experience_hours");

            ParticipantModel part;
            if (rs.getString("role").equalsIgnoreCase("Driver")) {
                part = new DriverModel(champId, teamId, id, name, licenseLvl, experienceHrs); 
            } 
            else if (rs.getString("role").equalsIgnoreCase("Navigator")) {
                boolean haveEquip = rs.getBoolean("have_equipment");
                part = new NavigatorModel(champId, teamId, id, name, licenseLvl, experienceHrs, haveEquip); 
            } 
            else {
                part = new ParticipantModel(champId, teamId, id, name, licenseLvl, experienceHrs);
            }
            System.out.println(part.getId()+"-"+part.getClass());
            list.add(part);
        }
        
        stmt.close();
        connection.close();
        
        return list;
    }
    
    public void editParticipantDB(ParticipantModel part) throws SQLException, Exception {
        String sql = "UPDATE participant SET champ_id = ?, team_id = ?, name = ?, license_lvl = ?, experience_hours = ? WHERE id = ?;";
        Connection connection;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionBD().conectorBD();
            stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, part.getChampId());
            stmt.setInt(2, part.getTeamId());
            stmt.setString(3, part.getName());
            stmt.setInt(4, part.getLicenseLvl());
            stmt.setInt(5, part.getExperienceHrs());
            stmt.setInt(6, part.getId());
            stmt.executeUpdate();
            
            
            if (part instanceof NavigatorModel) {
                NavigatorModel n = (NavigatorModel) part;
                String navigatorSql = "UPDATE navigator SET have_equipment = ? WHERE participant_id = ?";
                PreparedStatement stmtNavigator = connection.prepareStatement(navigatorSql);
                
                stmtNavigator.setBoolean(1, n.haveEquipment());
                stmtNavigator.setInt(2, n.getId());
                stmtNavigator.executeUpdate();
            }
            
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
    
    public void deleteParticipantDB(int champId, int teamId, int id) throws SQLException, Exception {
        String sql = "DELETE FROM participant WHERE id=? and champ_id=? and team_id=?;";
        Connection connection;
        PreparedStatement stmt = null;

        try {
            connection = new ConnectionBD().conectorBD();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, champId);
            stmt.setInt(3, teamId);
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
