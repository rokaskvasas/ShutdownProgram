package gui;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
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
        b1shut = new JButton("in 1 hour");
        b2shut = new JButton("in 2 hour");
        b3abort = new JButton("ABORT!!");
        timeLabel = new JLabel("Enter seconds till shutoff");
        seconds = new JTextField(10);

        //region add to frame
        this.add(background);
        background.add(b1shut);
        background.add(b2shut);
        background.add(b3abort,"wrap");
        background.add(timeLabel,"split 2, span 3");
        background.add(seconds);
        //endregion



    }
}
