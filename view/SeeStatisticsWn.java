package view;
import java.awt.event.*;
import javax.swing.*;
 
public class SeeStatisticsWn extends JFrame implements ActionListener {

    Frame myFrame;

    JPopupMenu info;
    JButton ok;

    public SeeStatisticsWn(Frame pNewFrame){

        myFrame = pNewFrame;

        setBounds(200, 200, 400, 300);
        setResizable(false);
        setVisible(true);
        setSize(450, 300);
        setLocation(500,300);
       
        String str1 = Integer.toString(myFrame.seeStatistics());

        info = new JPopupMenu();
        ok = new JButton("Ok");
        ok.setText("Number of Authors:  " + str1);
        add(ok);
    }
    
    public void actionPerformed(ActionEvent e){ 
        if (e.getActionCommand().equals("Ok")) {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING)); 
        }
    }
}
  