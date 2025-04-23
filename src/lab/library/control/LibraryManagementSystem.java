package lab.library.control;

import java.util.List;
import lab.library.entity.*;
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library("�߾� ������");

        addSampleBooks(library);

        System.out.println("===== " + library.getTotalBooks() + "���� ������ �߰��Ǿ����ϴ� =====");
        printLibraryStats(library);

        testFindBook(library);
        testCheckOut(library);
        testReturn(library);
        displayAvailableBooks(library);
    }

    public static void addSampleBooks(Library library) {
        library.addBook(new Book("�ڹ� ���α׷���", "���ڹ�", "978-89-01-12345-6", 2022));
        library.addBook(new Book("��ü������ ��ǰ� ����", "����ȣ", "978-89-01-67890-1", 2015));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
        library.addBook(new Book("Effective Java", "Joshua Bloch", "978-0-13-468599-1", 2018));
        library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
        library.addBook(new Book("�ڹ��� ����", "���ü�", "978-89-01-14077-4", 2019));
    }

    public static void testFindBook(Library library) {
        System.out.println("\n===== ���� �˻� �׽�Ʈ =====");

        Book bookByTitle = library.findBookByTitle("�ڹ��� ����");
        System.out.println("�������� �˻� ���:");
        System.out.println(bookByTitle);

        List<Book> booksByAuthor = library.findBooksByAuthor("Robert C. Martin");
        System.out.println("\n���ڷ� �˻� ���:");
        booksByAuthor.forEach(System.out::println);
    }

    public static void testCheckOut(Library library) {
        System.out.println("\n===== ���� ���� �׽�Ʈ =====");
        String isbn = "978-89-01-14077-4";
        boolean success = library.checkOutBook(isbn);
        if (success) {
            System.out.println("���� ���� ����!");
            System.out.println("����� ���� ����:");
            System.out.println(library.findBookByISBN(isbn));
        } else {
            System.out.println("���� ���� ����!");
        }

        printLibraryStats(library);
    }

    public static void testReturn(Library library) {
        System.out.println("\n===== ���� �ݳ� �׽�Ʈ =====");
        String isbn = "978-89-01-14077-4";
        boolean success = library.returnBook(isbn);
        if (success) {
            System.out.println("���� �ݳ� ����!");
            System.out.println("�ݳ��� ���� ����:");
            System.out.println(library.findBookByISBN(isbn));
        } else {
            System.out.println("���� �ݳ� ����!");
        }

        printLibraryStats(library);
    }

    public static void displayAvailableBooks(Library library) {
        System.out.println("\n===== ���� ������ ���� ��� =====");
        for (Book book : library.getAvailableBooks()) {
            System.out.println(book);
            System.out.println("------------------------");
        }
    }

    public static void printLibraryStats(Library library) {
        System.out.println("\n������ ���� ����:");
        System.out.println("��ü ���� ��: " + library.getTotalBooks());
        System.out.println("���� ���� ���� ��: " + library.getAvailableBooksCount());
        System.out.println("���� ���� ���� ��: " + library.getBorrowedBooksCount());
    }
}