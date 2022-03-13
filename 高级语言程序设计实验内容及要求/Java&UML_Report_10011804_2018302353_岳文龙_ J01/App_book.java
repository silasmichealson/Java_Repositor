//package book;

public class App_book {
    public static void main(String[] args)  {
        Book book1 = new Book();
        book1.setbook("java_test", 2020, 4, 12, 100000);
        book1.price(book1.Words_numb,book1.Pdate_m );
        System.out.println("price = "+book1.nprice);
    }
}