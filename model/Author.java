package model;
import java.util.*;

 public class Author {

    private String name;    
    private String dateOfBirth;
    private String country;
    private String writingGenre;
    private char nobel; 
    private char active;
    private String icon;
    private String booksPerAuthor;
    private ArrayList<Book> books; 

    // Constructor // 
    public Author(){
        books = new ArrayList<Book>();
    }

    // Add an author
    public Author(String pname, 
                  String pdateOfBirth, 
                  String pcountry, 
                  String pwritingGenre, 
                  char pNobel, 
                  char pActive, 
                  String pIcon){
        setName(pname);
        setDateOfBirth(pdateOfBirth);
        setCountry(pcountry);
        setWritingGenre(pwritingGenre);
        setNobel(pNobel);
        setActive(pActive);
        setIcon(pIcon);
        
    }

    // Add an author with books
    public Author(String pname, 
                  String pdateOfBirth, 
                  String pcountry, 
                  String pwritingGenre, 
                  char pNobel, 
                  char pActive, 
                  String pIcon, 
                  ArrayList<Book> pBooks
                  ){

        this(); // calling constructor to create instance of array Book
        setName(pname);
        setDateOfBirth(pdateOfBirth);
        setCountry(pcountry);
        setWritingGenre(pwritingGenre);
        setNobel(pNobel);
        setActive(pActive);
        setIcon(pIcon);
        setBooks(pBooks);
    }

    public void addBook(String pTitle, String pDate, String pGenre, String pCoverPage){
        books.add(new Book(pTitle, pDate, pGenre, pCoverPage)); 
        int lastindex = books.size() -1 ;
        System.out.println("Book added "+ books.get(lastindex));
    }

    public void deleteBook(int index){
        try{
            System.out.println(books.get(index) + " removed!");
            books.remove(index);
        }catch(Exception e){
            System.out.println("There is nothing here!."); 
        }
    }

    // Setters & Getters // 
    // Name
    public void setName(String pname) {
        this.name = pname;
    }
    public String getName(){
        return name;
    }
    // Birth
    public void setDateOfBirth(String pdateOfBirth) {
        this.dateOfBirth = pdateOfBirth;
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }
    // Country
    public void setCountry(String pcountry) {
        this.country = pcountry;
    }
    public String getCountry() {
        return country;
    }
    // Gender
    public void setWritingGenre(String pwritingGenre) {
        this.writingGenre = pwritingGenre;
    }
    public String getWritingGenre() {
        return writingGenre;
    }
    // Nobel
    public void setNobel(char pNobel) {
        this.nobel = pNobel;
    }
    public char getNobel() {
        return nobel;
    }
    // Active
    public void setActive(char active) {
        this.active = active;
    }
    public char getActive() {
        return active;
    }
    // Icon as String type
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getIcon() {
        return icon;
    }
    // Book
    public ArrayList<Book> getBooks() {
        return books;
    }
    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    // Return books
    public String getBooksPerAuthor() {
        return booksPerAuthor;
    }
    @Override 
    public String toString() {
        return " Name: " + this.getName() + ", Date of Birth: " + this.getDateOfBirth() + ", Country: " + this.getCountry() + ", Genre: " + getWritingGenre() + ", Nobel: " + this.getNobel() + ", Active: " + this.getActive() + ", Icon: " + this.getIcon() + ", Books: " + this.getBooks(); 
    }    
}
