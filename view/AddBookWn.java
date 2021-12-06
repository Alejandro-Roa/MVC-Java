package view;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;


public class AddBookWn extends JFrame implements ActionListener{

    JPanel formPanel;
    JPanel imagePanel;
    JPanel mainPanel;
    JButton commitButton;
    JButton addImageButton;
    JTextField titleJTextField;
    JTextField publicationJTextField;
    JTextField genreJTextField;
    JComboBox<String> authorsComboBox;
    Label authorLabel;
    Label titleLabel;
    Label publicationLabel;
    Label genreLabel;
    ImageIcon coverPage;
    JLabel myCoverLabel;
    GridBagConstraints newLayout;
    Frame myFrame;

    public AddBookWn (Frame pMyFrame){

        myFrame = pMyFrame;

        setResizable(false);
        setVisible(true);
        setLocation(500,300);
        setSize(550, 400);

        String[] myAuthors = myFrame.getNameOfAuthors(); 

        authorLabel = new Label("Author: ");
        titleLabel = new Label("Title: ");
        publicationLabel= new Label("Publication Date: ");
        genreLabel = new Label("Genre: ");

        formPanel = new JPanel();
        imagePanel = new JPanel();
        mainPanel = new JPanel();
        coverPage = new ImageIcon("MVC/Icons/addCover.png","Add cover"); 
        newLayout = new GridBagConstraints();

        myCoverLabel = new JLabel("Cover Page 166x 126", coverPage, SwingConstants.CENTER); 
        myCoverLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        titleJTextField = new JTextField(10); 
        publicationJTextField = new JTextField(10); 
        genreJTextField = new JTextField(10); 
        commitButton = new JButton("Submit");
        addImageButton = new JButton("Add cover page");

        authorsComboBox = new JComboBox<>(myAuthors); 
        authorsComboBox.addActionListener(this);

        commitButton.setVerticalTextPosition(AbstractButton.BOTTOM);
        commitButton.setHorizontalTextPosition(AbstractButton.CENTER);
        commitButton.setVisible(true);
        commitButton.addActionListener(this);
        addImageButton.addActionListener(this);
        addImageButton.setPreferredSize(new Dimension(5, 5));

        // form panel
        formPanel.setLayout(new GridLayout(5,0));
        formPanel.add(authorLabel);
        formPanel.add(authorsComboBox);
        formPanel.add(titleLabel);
        formPanel.add(titleJTextField);
        formPanel.add(publicationLabel);
        formPanel.add(publicationJTextField);
        formPanel.add(genreLabel);
        formPanel.add(genreJTextField);
        formPanel.add(commitButton);

        //image panel
        imagePanel.setLayout(new GridBagLayout()); 
        newLayout.fill = GridBagConstraints.HORIZONTAL;

        newLayout.ipady = 50;   
        newLayout.weightx = 0.0; 
        newLayout.gridwidth = 4;
        newLayout.gridx = 0;
        newLayout.gridy = 0;
        imagePanel.add(myCoverLabel, newLayout);

        newLayout.weightx = 0.5;
        newLayout.gridx = 0; 
        newLayout.gridy = 1;
        newLayout.anchor = GridBagConstraints.PAGE_END; 
        newLayout.insets = new Insets(5,0,0,0);  
        imagePanel.add(addImageButton, newLayout);

        mainPanel.setLayout(new GridLayout(1, 1)); 
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40,30,40,30)); 

        mainPanel.add(formPanel);
        mainPanel.add(imagePanel);
        add(mainPanel);
        pack();
    }


    public void actionPerformed(ActionEvent e){

        // commit
        if(e.getActionCommand().equals("Submit")){
            try{
                myFrame.createBook(authorsComboBox.getSelectedItem().toString(),titleJTextField.getText(), publicationJTextField.getText(), genreJTextField.getText(),"BookCover.png");   // myPhotoLabel.getIcon() add cover?       
                dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));  
            }catch(Exception ex){
                System.out.println("ERROR: -> " + ex); 
            }            
        }

        if(e.getActionCommand().equals("Add cover page")){
            JFrame addFile = new JFrame("Add Cover");
            JPanel addFilePanel = new JPanel();
            JFileChooser newFile = new JFileChooser(); 
            addFilePanel.add(newFile);
            addFile.add(addFilePanel);
            newFile.setDialogTitle("Choose a cover");
            newFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
            addFile.setLocation(500,300);
            addFile.setSize(550, 400);

            int returnval = newFile.showOpenDialog(this);
            if (returnval == JFileChooser.APPROVE_OPTION){
                File file = newFile.getSelectedFile();
                BufferedImage bi = null;
                try {
                    bi = ImageIO.read(file);
                    myCoverLabel.setIcon(new ImageIcon(bi));
                    myCoverLabel.setText(null);
                    addImageButton.setText("Remove Cover");
                } catch(IOException es) {
                es.printStackTrace(); 
                }
                pack();
            }
            addFile.dispatchEvent(new WindowEvent(addFile, WindowEvent.WINDOW_CLOSING)); 
        }

        if(e.getActionCommand().equals("Remove Cover")){    
            myCoverLabel.setIcon(coverPage);
            myCoverLabel.setText("Author Photo");
            addImageButton.setText("Add cover page");
            pack();
        }
    }
}


 