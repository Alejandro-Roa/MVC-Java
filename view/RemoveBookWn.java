package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemoveBookWn extends JFrame implements ActionListener {

    JPanel mainPanel;
    JButton commitButton;
    JComboBox<String> authorsComboBox;
    JComboBox<String> booksComboBox;
    Label authorLabel;
    Label bookLabel;
    GridBagConstraints newLayout;
    Frame myFrame;

    public RemoveBookWn (Frame pMyFrame){

        myFrame = pMyFrame;

        setResizable(false);
        setVisible(true);
        setLocation(500,300);
        setSize(550, 400);

        String[] myAuthors = myFrame.getNameOfAuthors();  
        String[] myBooks = myFrame.getBookTitles();
        
        authorLabel = new Label("Author: ");
        bookLabel = new Label("Book: ");
    
        mainPanel = new JPanel();
        newLayout = new GridBagConstraints();

        commitButton = new JButton("Submit");
        authorsComboBox = new JComboBox<>(myAuthors); 
        authorsComboBox.addActionListener(this);
        authorsComboBox.setPreferredSize(new Dimension(187, 30));
        booksComboBox = new JComboBox<>(myBooks); 
        booksComboBox.addActionListener(this);

        commitButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        commitButton.setHorizontalTextPosition(AbstractButton.CENTER);
        commitButton.setVisible(true);
        commitButton.addActionListener(this);

        mainPanel.setLayout(new GridLayout(3,2));
        mainPanel.add(authorLabel);
        mainPanel.add(authorsComboBox);
        mainPanel.add(bookLabel);
        mainPanel.add(booksComboBox);
        mainPanel.add(commitButton);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40,30,40,30)); 

        add(mainPanel);
        pack();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Submit")){
            try{
                myFrame.removeBook(authorsComboBox.getSelectedItem().toString(),booksComboBox.getSelectedItem().toString());   
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));  
            }catch(Exception ex){
                System.out.println("ERROR: -> " + ex); 
            }            
        }
    }
}


