package gui;

import constants.Text;
import models.Actions;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;


@SuppressWarnings("FieldCanBeLocal")

public class MainFrame extends JFrame {

    private final JButton b1shut,b2shut,b3abort, b4execute;
    private final JLabel background,timeLabel,errorLabel;
    private final JTextField seconds;

    public MainFrame(){
        this.setResizable(true);
        this.setSize(410,228);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        setIconImage(new ImageIcon(".\\src\\main\\java\\images\\windows_logo.png").getImage());
//        background = new JLabel(new ImageIcon(".\\src\\main\\java\\images\\Windows_XP_Shutdown.png"));
        background = new JLabel(new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("Windows_XP_Shutdown.png"))));
        background.setLayout(new MigLayout(
                "",
                "40[]40[]40[]",
                "80[]15[][]"
        ));
        b1shut = new JButton(Text.oneH);
        b2shut = new JButton(Text.twoH);
        b3abort = new JButton(Text.abort);
        b4execute = new JButton(Text.start);
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
        background.add(b4execute,"wrap");
        background.add(errorLabel= new JLabel(),"span, gapleft 90");

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
        seconds.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() >='0' && e.getKeyChar() <='9'){
                    b4execute.addActionListener(ee ->Actions.execute(seconds.getText()));
                    errorLabel.setText("");
                }else{
                    errorLabel.setText("*Enter only DIGITS!");
                    errorLabel.setForeground(Color.red);
                }
            }
        });
        b1shut.addActionListener(e -> Actions.oneHour());
        b2shut.addActionListener(e -> Actions.twoHour());
        b3abort.addActionListener(e -> Actions.abort());


        //endregion



    }
}
