package ch03.Book;

public class BooksTestDrive {
    public static void main(String[] args) {

        System.out.println();

        Book [] myBooks = new Book[3];

        myBooks[0] = new Book();
        myBooks[0].title = "The Grapes of Java";
        myBooks[0].author = "Bob";  

        myBooks[1] = new Book();
        myBooks[1].title = "The Java Gatsby";
        myBooks[1].author = "Sue";

        myBooks[2] = new Book();
        myBooks[2].title = "The Java Cookbook";
        myBooks[2].author = "Ian";

        int x = 0;
        while (x < 3) {
            System.out.printf(myBooks[x].title);
            System.out.printf(" by ");
            System.out.println(myBooks[x].author);
            x = x + 1;
        }
    }
}
