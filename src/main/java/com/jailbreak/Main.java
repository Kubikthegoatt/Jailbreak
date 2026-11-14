package com.jailbreak;
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.io.File;
import java.net.URI;
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Jailbreak");
        JPanel homePanel = new JPanel();
        JPanel storagePanel = new JPanel();
        JPanel settingsPanel = new JPanel();

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Home",homePanel);
        tabs.addTab("Storage",storagePanel);
        tabs.addTab("Settings",settingsPanel);
        window.add(tabs);

        // Home
        JLabel homelabel = new JLabel("Jailbreak");


        // Storage

        JProgressBar storagebar = new JProgressBar();
        File jarLocation = null;
        try {
             jarLocation = new File(
                    Main.class.getProtectionDomain()
                            .getCodeSource()
                            .getLocation()
                            .toURI()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        File dir = jarLocation.getParentFile();
        long total = dir.getTotalSpace();
        long free = dir.getFreeSpace();
        long used = total - free;
        int percentage = (int) ((used * 100.0) / total);
        JLabel storagelabel = new JLabel(percentage+"% has been used of ");
        storagePanel.add(storagelabel);
        storagebar.setValue(percentage);
        storagePanel.add(storagebar);
        homePanel.add(homelabel);
        window.setSize(400,300);
        window.setVisible(true);

    }
}
