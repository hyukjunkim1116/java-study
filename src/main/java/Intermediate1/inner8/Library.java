package Intermediate1.inner8;

public class Library {
    private static class Book {
        private final String title;
        private final String author;

        private Book(String title, String author) {
            this.title = title;
            this.author = author;
        }
    }

    private final Book[] books;
    private int bookCount = 0;

    public Library(int bookCount) {
        books = new Book[bookCount];
    }

    public void addBook(String title, String author) {
        if (bookCount == 4) {
            System.out.println("책 저장 공간이 부족합니다.");
            return;
        }
        books[bookCount] = new Book(title, author);
        bookCount++;
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println("도서 제목: " + book.title + ", 저자: " + book.author);
        }
    }
}
