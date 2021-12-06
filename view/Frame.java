package view;
import model.*;
import javax.swing.*;   
import java.awt.*;

public class Frame extends JFrame {

    Panel myJPanel;
    Library myLibrary;

    public Frame() { 

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        myJPanel = new Panel(this);
        myLibrary = new Library();
        add(myJPanel);  
    }

    //          panel methods            //

    // Add Author
    public void createAuthor(String pName, 
                             String pDateOfBirth,
                             String pCountry, 
                             String pWritingGenre, 
                             char pNobel, 
                             char pActive, 
                             String pIcon){  
        myLibrary.addAuthor(pName, pDateOfBirth, pCountry, pWritingGenre, pNobel, pActive, pIcon);
    }
    //Add Book
    public void createBook(String pAuthor, 
                        String pTitle, 
                        String pPublicationDate, 
                        String pGenre, 
                        String pCover){
        myLibrary.addBook(pAuthor, pTitle, pPublicationDate, pGenre, pCover);
    }
    
    // Remove Book
    public void removeBook(String pAuthor, String pBook){
       myLibrary.removeBook(pAuthor, pBook);
    }
    
    // See Statistics
    public int seeStatistics(){ // pending
        myLibrary.seeData(); 
        return myLibrary.seeStatistics();

    }
    // Get authors
    public String[] getNameOfAuthors() {
        return myLibrary.getNameOfAuthors();
    }

    // Get books
    public String[] getBookTitles(){
        return myLibrary.getBookTitles();
    }

    // Main method
    public static void main(String[] args){

        Frame newframe = new Frame();
        newframe.setTitle("My Library");
        newframe.setLocation(new Point(500,300));
        newframe.setSize(new Dimension(450, 300)); // l,w   
    }
}