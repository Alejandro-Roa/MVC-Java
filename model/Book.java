package model;
public class Book {

    private String title;
    private String publicationDate;
    private String genre;
    private String coverPage;
    
    public Book(){}

    public Book(String pTitle, String pPublicationDate, String pGenre, String pCoverPage){

        setTitle(pTitle);
        setPublicationDate(pPublicationDate);
        setGenre(pGenre);
        setCoverPage(pCoverPage);
    }

    //          Setters & Getters            // 

    // Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String pTitle) {
        this.title = pTitle;
    }
    // Date
    public String getDate() {
        return publicationDate;
    }
    public void setPublicationDate(String pPublicaDate) {
        this.publicationDate = pPublicaDate;
    }
    // Genre
    public String getGenre() {
        return genre;
    }
    public void setGenre(String pGenre) {
        this.genre = pGenre;
    }
    // Cover Page
    public String getCoverPage() {
        return coverPage;
    }
    public void setCoverPage(String pcoverPage) {
        this.coverPage = pcoverPage;
    }

    @Override 
    public String toString() {
        return " Title: " + this.getTitle() + ", Publication Date: " + this.getDate() + ", Genre: " + this.getGenre() + ", Cover Page: " + this.getCoverPage(); 
    }
}
