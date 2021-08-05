package gui;

import constants.Text;
import models.Actions;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@SuppressWarnings("FieldCanBeLocal")

public class MainFrame extends JFrame {

    private final JButton b1shut,b2shut,b3abort, b4execute;
    private final JLabel background,timeLabel;
    private final JTextField seconds;
    ActionListener buttonListener;

    public MainFrame(){
        this.setResizable(true);
        this.setSize(410,228);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        background = new JLabel(new ImageIcon(".\\src\\main\\java\\files\\Windows_XP_Shutdown.png"));
        background.setLayout(new MigLayout(
                "",
                "40[]40[]40[]",
                "80[]20[]"
        ));
        b1shut = new JButton(Text.oneH);
        b2shut = new JButton(Text.twoH);
        b3abort = new JButton(Text.abort);
        b4execute = new JButton(Text.execute);
        timeLabel = new JLabel(Text.seconds);
        seconds = new JTextField(10);
        seconds.setText(Text.entText);
        seconds.setForeground(Color.GRAY);
        b1shut.setBackground(Color.orange);
        b2shut.setBackground(new Color(0,204,0));
        b3abort.setBackground(new Color(255,80,0));
        b4execute.setBackground(Color.BLACK);
        b4execute.setForeground(Color.WHITE);


        //region add to frame
        this.add(background);
        background.add(b1shut);
        background.add(b2shut);
        background.add(b3abort,"wrap");
        background.add(timeLabel,"split 3, span 3");
        background.add(seconds);
        background.add(b4execute);
        //endregion
        //region Listener
        seconds.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(seconds.getText().equals(Text.entText)){
                    seconds.setText("");
                    seconds.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(seconds.getText().isEmpty()){
                    seconds.setText(Text.entText);
                    seconds.setForeground(Color.GRAY);
                }

            }
        });
        b1shut.addActionListener(e -> Actions.oneHour());
        b2shut.addActionListener(e -> Actions.twoHour());
        b3abort.addActionListener(e -> Actions.abort());
        b4execute.addActionListener(e ->Actions.execute(seconds.getText()));



    }
}
