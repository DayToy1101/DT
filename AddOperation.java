package operation;

import book.Book;
import book.BookList;

public class AddOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("添加书籍");
        System.out.println("请输入图书的名字：");
        String name=sc.next();
        System.out.println("输入图书的作者：");
        String author=sc.next();
        System.out.println("请输入图书的价格：");
        int price=sc.nextInt();
        System.out.println("请输入图书的类型：");
        String type=sc.next();
        Book book = new Book(name,author,price,type);
        int curSize=bookList.size;
        bookList.books[curSize]=book;
        bookList.size=curSize+1;
    }
}
