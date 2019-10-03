package conspect.oop;

public class UpcastingDowncasting {
    public static void main(String[] args) {
        ProgrammerBook prBook = new ProgrammerBook();
        Book book = prBook; //upcasting

        Book book1 = new ProgrammerBook();
        ProgrammerBook prBook1 = null;
        System.out.println(book1 instanceof ProgrammerBook);
        prBook1 = (ProgrammerBook) book1;//downcasting

        Book book2 = new Book();
        ProgrammerBook prBook2 = null;
        System.out.println(prBook2 instanceof ProgrammerBook);
        //prBook2 = (ProgrammerBook) book2; //error
    }
}

class Book{
}

class ProgrammerBook extends Book{
}
