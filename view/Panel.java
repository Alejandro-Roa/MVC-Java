package view;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Panel extends JPanel implements ActionListener {

    JButton addBook;
    JButton addAuthor;
    JButton removeBook;
    JButton seeStatistics;

    ImageIcon iconAddBook;
    ImageIcon iconAddAuthor;
    ImageIcon iconRemoveBook;
    ImageIcon iconSeeStatistics;

    Frame myFrame;

    AddAuthorWn myAuthorWn;
    AddBookWn myBookWn;
    RemoveBookWn myEditBookWn;
    SeeStatisticsWn myStatisticsWn;

    public Panel(Frame pMyFrame){ 

        myFrame = pMyFrame; 

        setLayout(new GridLayout(2,2));
        setVisible(true);
        setBorder(BorderFactory.createEmptyBorder(50,40,50,40)); 

        iconAddBook = new ImageIcon("MVC/Icons/addBook.png","Add book");
        iconAddAuthor = new ImageIcon("MVC/Icons/addAuthor.png","Add author");
        iconRemoveBook= new ImageIcon("MVC/Icons/removeBook.png","remove book"); 
        iconSeeStatistics = new ImageIcon("MVC/Icons/seeStatistics.png","see statistics");
       
        addAuthor = new JButton("Add author",iconAddAuthor);
        addBook = new JButton("Add book",iconAddBook);
        removeBook = new JButton("Remove book", iconRemoveBook);
        seeStatistics = new JButton("See statistics", iconSeeStatistics );

        addAuthor.addActionListener(this); 
        addBook.addActionListener(this); 
        removeBook.addActionListener(this); 
        seeStatistics.addActionListener(this); 

        add(addAuthor);
        add(addBook);
        add(removeBook);
        add(seeStatistics);
    }

    public void actionPerformed(ActionEvent e){

        System.out.println(e.getActionCommand() +" button pressed!.");

        //          Panel method             //

        // Add Author
        if(e.getActionCommand().equals("Add author")){
            myAuthorWn = new AddAuthorWn(myFrame); // or this 
            myAuthorWn.setTitle("Add Author"); // adds a window description v title
        }
        // Add Book
        if(e.getActionCommand().equals("Add book")){
            myBookWn = new AddBookWn(myFrame);
            myBookWn.setTitle("Add Book");
        }
        // Remove book
        if(e.getActionCommand().equals("Remove book")){ 
            myEditBookWn = new RemoveBookWn(myFrame);
            myEditBookWn.setTitle("Remove Book");

        // See Statistics
        }
        if(e.getActionCommand().equals("See statistics")){
            myStatisticsWn = new SeeStatisticsWn(myFrame);
            myStatisticsWn.setTitle("See statistics");
        }
    }
}
