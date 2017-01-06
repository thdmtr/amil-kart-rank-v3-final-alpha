package com.amil.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.amil.business.GeneralBusiness;
import com.amil.util.DataLoaderUtil;
import com.amil.vo.CurrentInformationVO;

/**
 * 
 * <p><b>Tailored for Amil Corporation.</b></p>
 * 
 * Requested by: Paulo Souza
 * Company: CUBO TECNOLOGIA
 * 
 * @author Dimitri Martins
 *
 */
public class MainGUI {
    private JFrame frame;

    public MainGUI() {
        this.initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        this.frame.setLocationRelativeTo(null);
        
        LinkedList<CurrentInformationVO> orderedList = GeneralBusiness.orderLapTimesAscending();
        
        Vector<String> data = new Vector<String>();
        Vector<String> columnNames = new Vector<String>();
        
        columnNames.add("Position");
        columnNames.add("Pilot ID");
        columnNames.add("Pilot Name");
        columnNames.add("No. Compl. Laps");
        columnNames.add("Lap Time");
        
        DefaultTableModel podiumTableModel = new DefaultTableModel(data, columnNames);
        
        Map<String, String> alreadyAddedPodiumEntries = new HashMap<String, String>();
        
        int cursor = 1;
        
        for (CurrentInformationVO ci : orderedList) {
            System.out.println(String.valueOf(ci.getLapNumber()) + " - PID: " + ci.getPilotID() + " - " + ci.getPilotName() + " - " + ci.getLapTime());
            
            if (ci.getLapNumber().equals("4") && !alreadyAddedPodiumEntries.containsKey(ci.getPilotID())) {
	            Vector<String> podiumEntry = new Vector<String>();
	            
	            podiumEntry.add(String.valueOf(cursor));
	            podiumEntry.add(ci.getPilotID());
	            podiumEntry.add(ci.getPilotName());
	            podiumEntry.add(ci.getLapNumber());
	            podiumEntry.add(ci.getLapTime());
	            
	            podiumTableModel.addRow(podiumEntry);
	            
	            alreadyAddedPodiumEntries.put(ci.getPilotID(), ci.getPilotName());
	            
	            cursor++;
            }
        }
        
        JTable podiumTable = new JTable(podiumTableModel);
        JScrollPane podiumTableScrollpane = new JScrollPane(podiumTable);
        
        podiumTable.setBounds(10, 10, 640, 280);
        podiumTableScrollpane.setBounds(podiumTable.getBounds());
        
        final JComboBox<String> pilotsComboBox = new JComboBox<String>();
        List<CurrentInformationVO> preloadedComparisonList = DataLoaderUtil.load();
        ArrayList<String> pilotsItems = new ArrayList<String>();
        
        for (CurrentInformationVO ci : preloadedComparisonList) {
            String assembledItem = "PID: " + ci.getPilotID() + " - " + ci.getPilotName();
            boolean alreadyExists = false;
            
            for (String s : pilotsItems) {
                if (s.equals(assembledItem)) {
	                alreadyExists = true;
	                
	                break;
                }
            }
            
            if (!alreadyExists) {
            	pilotsItems.add(assembledItem);
            }
        }
        
        for (String s : pilotsItems) {
            pilotsComboBox.addItem(s);
        }
        
        pilotsComboBox.setBounds(10, 300, 400, 30);
        
        JButton viewPilotBestTimeButton = new JButton("View best pilot time");
        
        viewPilotBestTimeButton.setBounds(450, 300, 200, 30);
        viewPilotBestTimeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String selectedPilot = (String)pilotsComboBox.getSelectedItem();
                String selectedPilotID = selectedPilot.split(" ")[1];
                
                JOptionPane.showMessageDialog(null, "Best lap time for this pilot:\n" + GeneralBusiness.getBestLapTimeByPilotID(selectedPilotID).toString().split(" ")[1]);
            }
        });
        
        JComboBox<String> pilotsAvgSpdComboBox = new JComboBox<String>();
        ArrayList<String> pilotsAvgSpdItems = new ArrayList<String>();
        
        for (CurrentInformationVO ci : preloadedComparisonList) {
            String assembledItem = "PID: " + ci.getPilotID() + " - " + ci.getPilotName();
            boolean alreadyExists = false;
            
            for (String s : pilotsAvgSpdItems) {
                if (s.equals(assembledItem)) {
	                alreadyExists = true;
	                
	                break;
                }
            }
            
            if (!alreadyExists) {
            	pilotsAvgSpdItems.add(assembledItem);
            }
        }
        
        for (String s : pilotsAvgSpdItems) {
            pilotsAvgSpdComboBox.addItem(s);
        }
        
        pilotsAvgSpdComboBox.setBounds(10, 350, 400, 30);
        
        JButton viewPilotAvgSpdButton = new JButton("View pilot average speed");
        
        viewPilotAvgSpdButton.setBounds(450, 350, 200, 30);
        viewPilotAvgSpdButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String selectedPilot = (String)pilotsAvgSpdComboBox.getSelectedItem();
                String selectedPilotID = selectedPilot.split(" ")[1];
                
                JOptionPane.showMessageDialog(null, "Average driving speed for this pilot:\n" + GeneralBusiness.getAveragePilotDrivingSpeed(selectedPilotID).toString() + " kM/h");
            }
        });
        
        this.frame.getContentPane().add(podiumTableScrollpane);
        this.frame.getContentPane().add(viewPilotBestTimeButton);
        this.frame.getContentPane().add(pilotsComboBox);
        this.frame.getContentPane().add(viewPilotAvgSpdButton);
        this.frame.getContentPane().add(pilotsAvgSpdComboBox);
        this.frame.setLayout(null);
        this.frame.setTitle("Amil - Kart Rank");
        this.frame.setDefaultCloseOperation(3);
        this.frame.repaint();
        this.frame.pack();
        this.frame.setSize(700, 450);
        this.frame.setResizable(false);
        this.frame.setVisible(true);
    }

    public JFrame getFrame() {
        return this.frame;
    }

}

