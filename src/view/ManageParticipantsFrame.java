/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.ParticipantController;
import controller.TeamController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DriverModel;
import model.NavigatorModel;
import model.ParticipantModel;
import model.TeamModel;

/**
 *
 * @author fabri
 */
public class ManageParticipantsFrame extends javax.swing.JInternalFrame {
    private int champId;
    private ArrayList<TeamModel> listTeam;
    private ArrayList<ParticipantModel> list;
    /**
     * Creates new form ManageParticipants
     */
    public ManageParticipantsFrame(int champId) {
        this.champId = champId;
        this.listTeam = new ArrayList<>();
        this.list = new ArrayList<>();
        initComponents();
        initList();
        initListTeams();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TeamsComboBox = new javax.swing.JComboBox<>();
        NameInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        driverPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        driverLvlInput = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        driverHoursInput = new javax.swing.JTextField();
        navigatorPanel = new javax.swing.JPanel();
        navigatorHoursInput = new javax.swing.JTextField();
        navigatorLvlInput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        equipmentCheckbox = new javax.swing.JCheckBox();
        cancelBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ParticipantComboBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        DeleteTeamComboBox = new javax.swing.JComboBox<>();
        DeleteParticipantBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        DeleteParticipantComboBox1 = new javax.swing.JComboBox<>();

        setClosable(true);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Participants List");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Champ_ID", "Team_ID", "ID", "Name", "Licence_lvl", "Exp_hrs", "have_equipment"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(10);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(1).setMinWidth(10);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(10);
            jTable1.getColumnModel().getColumn(2).setMinWidth(10);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(10);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(311, 311, 311))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("List", jPanel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Edit Parcipant");

        TeamsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        TeamsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TeamsComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Name:");

        driverPanel.setEnabled(false);

        jLabel4.setText("License lvl:");

        driverLvlInput.setEnabled(false);

        jLabel5.setText("Hours driven:");

        driverHoursInput.setEnabled(false);

        javax.swing.GroupLayout driverPanelLayout = new javax.swing.GroupLayout(driverPanel);
        driverPanel.setLayout(driverPanelLayout);
        driverPanelLayout.setHorizontalGroup(
            driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driverPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(driverPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(driverHoursInput, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(driverPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(driverLvlInput, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        driverPanelLayout.setVerticalGroup(
            driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(driverPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(driverLvlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(driverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(driverHoursInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        navigatorPanel.setEnabled(false);

        navigatorHoursInput.setEnabled(false);

        navigatorLvlInput.setEnabled(false);

        jLabel7.setText("Hours navigated:");

        jLabel6.setText("License lvl:");

        equipmentCheckbox.setText("Have equipment");
        equipmentCheckbox.setEnabled(false);
        equipmentCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navigatorPanelLayout = new javax.swing.GroupLayout(navigatorPanel);
        navigatorPanel.setLayout(navigatorPanelLayout);
        navigatorPanelLayout.setHorizontalGroup(
            navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(navigatorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(navigatorHoursInput))
                    .addGroup(navigatorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(navigatorLvlInput, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigatorPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(equipmentCheckbox)
                .addGap(45, 45, 45))
        );
        navigatorPanelLayout.setVerticalGroup(
            navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigatorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(navigatorLvlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(navigatorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(navigatorHoursInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(equipmentCheckbox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Edit");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        jLabel9.setText("Team_ID:");

        jLabel10.setText("Participant_ID:");

        ParticipantComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ParticipantComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParticipantComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(driverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navigatorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(124, 124, 124))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TeamsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ParticipantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(cancelBtn)
                        .addGap(177, 177, 177)
                        .addComponent(addBtn))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TeamsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(ParticipantComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(driverPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(navigatorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(cancelBtn))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Edit", jPanel2);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Delete Participant");

        jLabel12.setText("Team:");

        DeleteTeamComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DeleteParticipantBtn.setText("Delete");
        DeleteParticipantBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteParticipantBtnActionPerformed(evt);
            }
        });

        jLabel13.setText("Participant:");

        DeleteParticipantComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteTeamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(DeleteParticipantBtn))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeleteParticipantComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteTeamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteParticipantComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(29, 29, 29)
                .addComponent(DeleteParticipantBtn)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delete", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void equipmentCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentCheckboxActionPerformed
        
    }//GEN-LAST:event_equipmentCheckboxActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        try{
            int teamId = (Integer) this.TeamsComboBox.getSelectedItem();
            int id = (Integer) this.ParticipantComboBox.getSelectedItem();
            String name = this.NameInput.getText();
            
            ParticipantController partC = new ParticipantController();
            
            if(equipmentCheckbox.isEnabled()) {
                int lvl = Integer.parseInt(this.navigatorLvlInput.getText());
                int hrs = Integer.parseInt(this.navigatorHoursInput.getText());
                boolean haveEquip = equipmentCheckbox.isSelected();
                partC.edit(this.champId, teamId, id, name, lvl, hrs, haveEquip);
            }
            else{
                int lvl = Integer.parseInt(this.driverLvlInput.getText());
                int hrs = Integer.parseInt(this.driverHoursInput.getText());
                partC.edit(this.champId, teamId, id, name, lvl, hrs); 
            }
            
            TeamController teamC = new TeamController();
            teamC.edit(this.champId, name, id);
            
            initList();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error with DB {"+e.toString()+"}");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error {"+e.toString()+"}");
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void TeamsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TeamsComboBoxActionPerformed
    }//GEN-LAST:event_TeamsComboBoxActionPerformed

    private void ParticipantComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParticipantComboBoxActionPerformed
        int indexTeam = this.TeamsComboBox.getSelectedIndex();
        int index = this.ParticipantComboBox.getSelectedIndex();
        
        if (this.list != null && index >= 0) {
            ParticipantModel partM = this.list.get(index);
            this.NameInput.setText(partM.getName());
            if (partM instanceof DriverModel){
                toggleTypes(true);
                driverLvlInput.setText(partM.getLicenseLvl()+"");
                driverHoursInput.setText(partM.getExperienceHrs()+"");
            }
            else{
                toggleTypes(false);
                navigatorHoursInput.setText(partM.getExperienceHrs()+"");
                navigatorLvlInput.setText(partM.getLicenseLvl()+"");
                boolean equip = ((NavigatorModel)partM).haveEquipment();
                equipmentCheckbox.setSelected(equip);
            }
        }
    }//GEN-LAST:event_ParticipantComboBoxActionPerformed

    private void DeleteParticipantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteParticipantBtnActionPerformed
        try{
            int id = (Integer) this.DeleteParticipantComboBox1.getSelectedItem();
            int teamId = (Integer) this.DeleteTeamComboBox.getSelectedItem();
            
            ParticipantController partC = new ParticipantController();
            partC.delete(this.champId, teamId, id);
            
            initList();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error with DB {"+e.toString()+"}");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error {"+e.toString()+"}");
        }
    }//GEN-LAST:event_DeleteParticipantBtnActionPerformed

    private void toggleTypes(boolean isDriver){
        driverLvlInput.setEnabled(isDriver);
        driverHoursInput.setEnabled(isDriver);
        navigatorHoursInput.setEnabled(!isDriver);
        navigatorLvlInput.setEnabled(!isDriver);

    }
    
    private void initListTeams(){        
        try {        
            DefaultComboBoxModel dcm = (DefaultComboBoxModel) TeamsComboBox.getModel();
            dcm.removeAllElements();
        
            DefaultComboBoxModel dcmd = (DefaultComboBoxModel) DeleteTeamComboBox.getModel();
            dcmd.removeAllElements();
            
            TeamController teamC = new TeamController();
            this.listTeam = teamC.list(this.champId);
            
            for(int i = 0; i < this.listTeam.size(); i++){
                TeamModel team = this.listTeam.get(i);
                dcm.addElement(team.getId());
                dcmd.addElement(team.getId());
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error with DB {"+e.toString()+"}");
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro {"+e.toString()+"}");
        }
    }
    
    private void initList(){        
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setNumRows(0);
        
            DefaultComboBoxModel dcm = (DefaultComboBoxModel) ParticipantComboBox.getModel();
            dcm.removeAllElements();
        
            DefaultComboBoxModel dcmd = (DefaultComboBoxModel) DeleteParticipantComboBox1.getModel();
            dcmd.removeAllElements();
            
            ParticipantController partC = new ParticipantController();
            this.list = partC.list(this.champId);
            
            for(int i = 0; i < this.list.size(); i++){
                ParticipantModel part = this.list.get(i);
                if (part instanceof NavigatorModel) {
                    dtm.addRow(new Object[]{
                        part.getChampId(),
                        part.getTeamId(),
                        part.getId(),
                        part.getName(),
                        part.getLicenseLvl(),
                        part.getExperienceHrs(),
                        ((NavigatorModel) part).haveEquipment()
                    }
                    );
                } else if (part instanceof DriverModel) {
                    dtm.addRow(new Object[]{
                        part.getChampId(),
                        part.getTeamId(),
                        part.getId(),
                        part.getName(),
                        part.getLicenseLvl(),
                        part.getExperienceHrs()
                    }
                    );
                }
                
                dcm.addElement(part.getId());
                dcmd.addElement(part.getId());
            }
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error with DB {"+e.toString()+"}");
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro {"+e.toString()+"}");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteParticipantBtn;
    private javax.swing.JComboBox<String> DeleteParticipantComboBox1;
    private javax.swing.JComboBox<String> DeleteTeamComboBox;
    private javax.swing.JTextField NameInput;
    private javax.swing.JComboBox<String> ParticipantComboBox;
    private javax.swing.JComboBox<String> TeamsComboBox;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextField driverHoursInput;
    private javax.swing.JTextField driverLvlInput;
    private javax.swing.JPanel driverPanel;
    private javax.swing.JCheckBox equipmentCheckbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField navigatorHoursInput;
    private javax.swing.JTextField navigatorLvlInput;
    private javax.swing.JPanel navigatorPanel;
    // End of variables declaration//GEN-END:variables
}
