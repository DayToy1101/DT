package operation;

import book.BookList;

public class Exit implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("Exit");
        System.exit(0);
    }

}
