package model;
import java.util.*;

public class Library extends Author {

    private int numberOfBooks;  
    private String name;
    private int numberOfAuthors; 
    private ArrayList<Author> authors; 

    // Author's info
    ArrayList<String> authorNames;
    String [] authorNamesArray;

    ArrayList<String> authorDates;
    ArrayList<String> authorCountries;
    ArrayList<String> authorGenres;
    ArrayList<Character> authorNobels;
    ArrayList<Character> activeAuthors;
    ArrayList<String> authorIcons;

    // Book's info
    ArrayList<String> bookTitles;
    String [] bookTitlesArray; 

    ArrayList<String> bookAuthors;
    ArrayList<String> bookDates;
    ArrayList<String> bookGenres;
    ArrayList<String> bookCovers;

    // Constructor //
    public Library(){

        setNumberOfAuthors(0);
        authors = new ArrayList<Author>();
        authorNames = new ArrayList<String>();
        authorDates = new ArrayList<String>();
        authorCountries = new ArrayList<String>();
        authorGenres = new ArrayList<String>();
        authorNobels = new ArrayList<Character>();
        activeAuthors = new ArrayList<Character>();
        authorIcons = new ArrayList<String>();
        
        bookTitles = new ArrayList<String>();
        bookAuthors = new ArrayList<String>();
        bookDates = new ArrayList<String>();
        bookGenres = new ArrayList<String>();
        bookCovers = new ArrayList<String>();
    }

    // Add Author // 
    public void addAuthor(String pName, 
                          String pDateOfBirth, 
                          String pCountry, 
                          String pWritingGenre, 
                          char pNobel, 
                          char pActive, 
                          String pIcon){  

            authorNames.add(pName);
            authorDates.add(pDateOfBirth); 
            authorCountries.add(pCountry); 
            authorGenres.add(pWritingGenre); 
            authorNobels.add(pNobel); 
            activeAuthors.add(pActive); 
            authorIcons.add(pIcon);

            authors.add(new Author(pName, pDateOfBirth, pCountry, pWritingGenre, pNobel, pActive, pIcon)); 
            int lastindex = authors.size() -1 ;
            System.out.println("Author added "+ authors.get(lastindex));
            numberOfAuthors++;   
    }

    // Add books  "Multiple authors, multiple books" //
    public void addBook(String pAuthor, 
                        String pTitle, 
                        String pDate, 
                        String pGenre, 
                        String pCover){  

            for(int i = 0; i < authorNames.size(); i++){
                if(authorNames.get(i).equals(pAuthor)){
                    authors.remove(i);

                    Author myAuthor = new Author();

                    // ref table
                    bookTitles.add(pTitle);
                    bookAuthors.add(pAuthor);

                    bookDates.add(pDate);
                    bookGenres.add(pGenre);
                    bookCovers.add(pCover);
                    
        
                    // finding books for the author
                    for(int j = 0; j < bookAuthors.size(); j++){
                        if(bookAuthors.get(j).equals(pAuthor)){
                            myAuthor.addBook(bookTitles.get(j), bookDates.get(j), bookGenres.get(j) , bookCovers.get(j));
                        }
                    }
                
                    authors.add(i, new Author(authorNames.get(i),
                                              authorDates.get(i),
                                              authorCountries.get(i),
                                              authorGenres.get(i),
                                              authorNobels.get(i),
                                              activeAuthors.get(i),
                                              authorIcons.get(i), 
                                              myAuthor.getBooks())); 
                                              myAuthor.setBooks(null);
                    System.out.println("Author with books added! "+ authors.get(i));
                    break;
                }
            }
    }

    public void removeBook(String pAuthor, String pBook){
        if(bookAuthors.indexOf(pAuthor) == bookTitles.indexOf(pBook)){
            for(int i = 0; i < authorNames.size(); i++){
                if(authorNames.get(i).equals(pAuthor)){
                    authors.remove(i);

                    Author myAuthorb = new Author();
                    int size = bookTitles.size();

                    for(int j = 0; j < size; j++){
                        if(bookTitles.get(j).equals(pBook)){
                            bookTitles.set(j,"Deleted"); // fix ?
                            bookAuthors.set(j,"Deleted");

                            bookDates.set(j,"Deleted");
                            bookGenres.set(j,"Deleted");
                            bookCovers.set(j,"Deleted");
                            break;
                        }
                    }
                    for(int k = 0; k < bookAuthors.size(); k++){
                        if(bookAuthors.get(k).equals(pAuthor)){
                            myAuthorb.addBook(bookTitles.get(k), bookDates.get(k), bookGenres.get(k) , bookCovers.get(k));
                        }
                    }

                    authors.add(i, new Author(authorNames.get(i),
                                            authorDates.get(i),
                                            authorCountries.get(i),
                                            authorGenres.get(i),
                                            authorNobels.get(i),
                                            activeAuthors.get(i),
                                            authorIcons.get(i), 
                                            myAuthorb.getBooks())); 

                    myAuthorb.setBooks(null);
                    System.out.println(pBook +" was removed from the author " + pAuthor);
                    System.out.println(authors.get(i));
                    break;
                }
            }
        }else{
            System.out.println("The author " + pAuthor +" is not associated with the book "+ pBook);
        }          
    }

    
    public int seeStatistics(){ 
         return  numberOfAuthors;
    }

    // Setters & Getters //
    // Books
    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }
    public int getNumberOfBooks() {
        return numberOfBooks;
    }
    // Name
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    // Number of Authors 
    public void setNumberOfAuthors(int pNumberOfAuthors) {
        this.numberOfAuthors = pNumberOfAuthors;
    }
    public int getNumberOfAuthors() {
        return numberOfAuthors;
    }
    // Author information
    public ArrayList<Author> getAuthors() {
        return authors;
    }
    public void seeData(){
        for(int i = 0; i < authors.size(); i++){
                System.out.println(authors.get(i));
        }
    }

    // Get authors
    public String[] getNameOfAuthors() {
        authorNamesArray = new String[authorNames.size()];
        authorNamesArray =  authorNames.toArray(authorNamesArray);
        return authorNamesArray;
    }

    // Get books
    public String[] getBookTitles(){
        bookTitlesArray = new String[bookTitles.size()];
        bookTitlesArray = bookTitles.toArray(bookTitlesArray);
        return bookTitlesArray;
    }

}
