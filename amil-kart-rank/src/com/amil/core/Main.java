package com.amil.core;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JOptionPane;

import com.amil.gui.MainGUI;
import com.amil.util.DataLoaderUtil;

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
public class Main {
	
	/**
	 * 
	 * <p><b>Boot application.</b></p>
	 * 
	 */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    String fullQualifiedPath = null;
                    
                    JOptionPane.showMessageDialog(null, "Amil - Kart Rank\nRequested by: Paulo Souza\nCompany: CUBO TECNOLOGIA\n\nClick OK to begin.");
                    
                    while(true) {
                        try {
                            File f;
                            
                            while (!(f = new File(fullQualifiedPath = JOptionPane.showInputDialog("Please, input the complete qualified file path below and click OK."))).exists()) {
                                JOptionPane.showMessageDialog(null, "The given file does not exists.");
                            }
                            
                            break;
                        } catch (Exception e) {
                            int result = JOptionPane.showConfirmDialog(null, "Invalid file, the file must contain the full qualified path and/or extension.\nIf you wish, click cancel to exit application.");
                            
                            if (result == JOptionPane.NO_OPTION || result == JOptionPane.CANCEL_OPTION) {
                            	System.exit(0);
                            }
                        }
                    }
                    
                    DataLoaderUtil.fullQualifiedPath = fullQualifiedPath;
                    
                    MainGUI window = new MainGUI();
                    
                    window.getFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

