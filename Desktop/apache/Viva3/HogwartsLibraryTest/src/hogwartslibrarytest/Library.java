/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hogwartslibrarytest;

/**
 *
 * @author kwong
 */
import java.util.*;
public class Library {
    private List<Book> books;
    
    public Library(){
        this.books= new ArrayList<>();
    }
    
    public void addBook(Book book){
        books.add(book);
    }
    
    public void removeBook(String ISBN){
        books.removeIf(book -> book.getISBN().equals(ISBN));
    }
        
    public void findBooksByAuthor(String author){
        System.out.println("Books with author '"+author+ "':");
        boolean found= false;
        for(Book book: books){
            if(book.getAuthor().equals(author)){
                displayBookInfo(book);
                found= true;
            }
        }
    }
    
    public void findBooksByTitle(String title){
        System.out.println("Books with title '"+title+ "':");
        boolean found= false;
        for(Book book: books){
            if(book.getTitle().equals(title)){
                displayBookInfo(book);
                found= true;
            }
        }
    }
    
    public boolean borrowBook(String ISBN){
        Iterator<Book> iterator= books.iterator();
        while(iterator.hasNext()){
            Book book= iterator.next();
            if(book.getISBN().equals(ISBN) && !isPrimeDigitsEnding(ISBN)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    
    private boolean isPrimeDigitsEnding(String ISBN){
        int lastTwoDigits= Integer.parseInt(ISBN.substring(ISBN.length()-2));
        return lastTwoDigits == 11 || lastTwoDigits == 13 || lastTwoDigits == 17 || lastTwoDigits == 19 ||
            lastTwoDigits == 23 || lastTwoDigits == 29 || lastTwoDigits == 31 || lastTwoDigits == 37 ||
            lastTwoDigits == 41 || lastTwoDigits == 43 || lastTwoDigits == 47 || lastTwoDigits == 53 ||
            lastTwoDigits == 59 || lastTwoDigits == 61 || lastTwoDigits == 67 || lastTwoDigits == 71 ||
            lastTwoDigits == 73 || lastTwoDigits == 79 || lastTwoDigits == 83 || lastTwoDigits == 89 ||
            lastTwoDigits == 97;
    }
    
    public void sortBooks(){
        Collections.sort(books, Comparator. comparing(Book :: getTitle));
        System.out.println("Books sorted by title: ");
    }
    
    public void displayLibrary(){
        System.out.println("Books in the library, sorted by title: ");
        if(books.isEmpty()){
            System.out.println("No books in the library");
        }
        else{
            for(Book book: books){
            displayBookInfo(book);
        }
        }
    }
    
    public void displayBookInfo(Book book){
        System.out.println("- Title: "+ book.getTitle()+ "\n  Author: "+ book.getAuthor()+ "\n  ISBN: "+ book.getISBN());
        System.out.println();
    }
}
