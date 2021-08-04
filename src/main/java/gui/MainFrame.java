package gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(){
        this.setResizable(true);
        this.setVisible(true);
        this.setSize(400,200);
        this.setLayout(new MigLayout(
                "","[]20[]20","[]50"
        ));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel background = new JLabel(new ImageIcon(".\\src\\main\\java\\files\\Windows_XP_Shutdown.png"));
        JLabel shutdown1hLabel = new JLabel("Shutdown in 1 hour");
        JLabel shutdown2hLabel = new JLabel("Shutdown in 2 hour");
        JLabel abortLabel = new JLabel("ABORT!!");
        JButton shutdown1hButton = new JButton("Execute");
        JButton shutdown2hButton = new JButton("Execute");
        JButton abortButton = new JButton("ABORT!!");
        //region adding to frame
        this.add(shutdown1hLabel,"span 2");
        this.add(shutdown2hLabel,"span 2");
        this.add(abortLabel,"span 2 , wrap");
        this.add(shutdown1hButton,"span 2");
        this.add(shutdown2hButton,"span 2");
        this.add(abortButton);
        this.add(background);
        background.setLayout(new FlowLayout());
        //endregion
    }

}
