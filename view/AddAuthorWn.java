package view;

import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;

public class AddAuthorWn extends JFrame implements ActionListener {

    JPanel formPanel;
    JPanel imagePanel;
    JPanel mainPanel;
    JButton commitButton;
    JButton addImageButton;
    JTextField nameJTextField;
    JTextField nationalityJTextField;
    JTextField dateOfBirthJTextField;
    JTextField genreJTextField;
    JToggleButton nobelToggleButton;
    JToggleButton activeToggleButton;
    Label nameLabel;
    Label birthLabel;
    Label nationalityLabel;
    Label genreLabel;
    ImageIcon authorIcon;
    JLabel myPhotoLabel;
    GridBagConstraints newLayout;
    Frame myFrame;
    
    public AddAuthorWn(Frame pMyFrame){

        myFrame = pMyFrame;

        setResizable(false);
        setVisible(true);
        setLocation(500,300);
        setSize(550, 400);
        
        nameLabel = new Label("Name: ");
        birthLabel= new Label("Date: ");
        nationalityLabel = new Label("Country: ");
        genreLabel = new Label("Genre");
        
        formPanel = new JPanel();
        imagePanel = new JPanel();
        mainPanel = new JPanel();
        authorIcon = new ImageIcon("MVC/Icons/addPhoto.png","Add photo");
        newLayout = new GridBagConstraints();
        
        myPhotoLabel = new JLabel("Author Photo 218px 159", authorIcon, SwingConstants.CENTER); 
        myPhotoLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        nameJTextField = new JTextField(10); // name, columns
        nationalityJTextField = new JTextField(10); 
        dateOfBirthJTextField = new JTextField(10); 
        genreJTextField = new JTextField(10); 
        commitButton = new JButton("Submit");
        addImageButton = new JButton("Add photo");

        //addImageButton.setActionCommand(final String);
        
        nobelToggleButton = new JCheckBox("Nobel price");  
        activeToggleButton = new JCheckBox("Active");  

        commitButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        commitButton.setHorizontalTextPosition(AbstractButton.CENTER);
        commitButton.setVisible(true);
        commitButton.addActionListener(this);
        addImageButton.addActionListener(this);
        addImageButton.setPreferredSize(new Dimension(5, 5)); 

        // form panel
        formPanel.setLayout(new GridLayout(6,0));
        formPanel.add(nameLabel);
        formPanel.add(nameJTextField);
        formPanel.add(birthLabel);
        formPanel.add(dateOfBirthJTextField);
        formPanel.add(nationalityLabel);
        formPanel.add(nationalityJTextField);
        formPanel.add(genreLabel);
        formPanel.add(genreJTextField);
        formPanel.add(nobelToggleButton);
        formPanel.add(activeToggleButton);
        formPanel.add(commitButton); 

        //image panel
        imagePanel.setLayout(new GridBagLayout()); 
        newLayout.fill = GridBagConstraints.HORIZONTAL;

        newLayout.ipady = 50;    
        newLayout.weightx = 0.0; 
        newLayout.gridwidth = 4;
        newLayout.gridx = 0;
        newLayout.gridy = 0;
        imagePanel.add(myPhotoLabel, newLayout);

        newLayout.weightx = 0.5;
        newLayout.gridx = 0; 
        newLayout.gridy = 1;
        newLayout.anchor = GridBagConstraints.PAGE_END; 
        newLayout.insets = new Insets(5,0,0,0);  
        imagePanel.add(addImageButton, newLayout);

        mainPanel.setLayout(new GridLayout(1, 1)); 
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40,30,40,30)); 
        //mainPanel.setBackground(Color.lightGray); 

        mainPanel.add(formPanel);
        mainPanel.add(imagePanel);
        add(mainPanel);
        pack();
    }

    public void actionPerformed(ActionEvent e){

        // commit
        if(e.getActionCommand().equals("Submit")){

            char novelValue = 'N';
            char activeValue = 'N';
            if(nobelToggleButton.isSelected() == true){
                novelValue = 'Y';
            }
            if(activeToggleButton.isSelected() == true){
                activeValue = 'Y';
            }

            try{
                myFrame.createAuthor(nameJTextField.getText(), dateOfBirthJTextField.getText(), nationalityJTextField.getText(), genreJTextField.getText(),novelValue, activeValue,"AuthorPhoto.png");         
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));  
            }catch(Exception ex){
                System.out.println("ERROR: -> " + ex); 
            }            
        }
         
        // photo method
        if(e.getActionCommand().equals("Add photo")){
            JFrame addFile = new JFrame("Add Photo");
            JPanel addFilePanel = new JPanel();
            JFileChooser newFile = new JFileChooser(); 
            addFilePanel.add(newFile);
            addFile.add(addFilePanel);
            newFile.setDialogTitle("Choose a photo");
            newFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
            addFile.setLocation(500,300);
            addFile.setSize(550, 400);

            int returnval = newFile.showOpenDialog(this);
            if (returnval == JFileChooser.APPROVE_OPTION){
                File file = newFile.getSelectedFile();
                BufferedImage bi = null;
                try {
                    bi = ImageIO.read(file);
                    myPhotoLabel.setIcon(new ImageIcon(bi));
                    myPhotoLabel.setText(null);
                    addImageButton.setText("Remove Photo");
                } catch(IOException es) {
                es.printStackTrace(); 
                }
                pack();
            }
            addFile.dispatchEvent(new WindowEvent(addFile, WindowEvent.WINDOW_CLOSING)); 
        }

        if(e.getActionCommand().equals("Remove Photo")){    
            myPhotoLabel.setIcon(authorIcon);
            myPhotoLabel.setText("Author Photo");
            addImageButton.setText("Add photo");
            pack();
        }
    }
}