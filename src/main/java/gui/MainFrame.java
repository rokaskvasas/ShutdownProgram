package gui;

import constants.Buttons;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

@SuppressWarnings("FieldCanBeLocal")

public class MainFrame extends JFrame {

    private final JButton b1shut,b2shut,b3abort;
    private final JLabel background,timeLabel;
    private final JTextField seconds;

    public MainFrame(){
        this.setResizable(true);
        this.setSize(398,238);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        background = new JLabel(new ImageIcon(".\\src\\main\\java\\files\\Windows_XP_Shutdown.png"));
        background.setLayout(new MigLayout(
                "",
                "40[]40[]40[]",
                "80[]20[]"
        ));
        b1shut = new JButton(Buttons.oneH);
        b2shut = new JButton(Buttons.twoH);
        b3abort = new JButton(Buttons.abort);
        timeLabel = new JLabel(Buttons.seconds);
        seconds = new JTextField(10);
        seconds.setText(Buttons.entText);
        b1shut.setBackground(Color.orange);
        b2shut.setBackground(new Color(0,204,0));
        b3abort.setBackground(new Color(255,80,0));


        //region add to frame
        this.add(background);
        background.add(b1shut);
        background.add(b2shut);
        background.add(b3abort,"wrap");
        background.add(timeLabel,"split 2, span 3");
        background.add(seconds);
        //endregion
        //region Listener
        seconds.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(seconds.getText().equals(Buttons.entText)){
                    seconds.setText("");
                    seconds.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(seconds.getText().isEmpty()){
                    seconds.setText(Buttons.entText);
                    seconds.setForeground(Color.GRAY);
                }

            }
        });
        //endregion



    }
}
