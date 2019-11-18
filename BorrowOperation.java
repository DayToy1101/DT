package operation;

import book.Book;
import book.BookList;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("BorrowOperation");
        //并不会把bookList里面的书籍删除，利用isBorrow判断该书是否被借出
        System.out.println("输入你要借阅的图书的名称：");
        String name=sc.next();
        //1、看这本书是否存在
        int i=0;
        for(i=0;i<bookList.getSize();i++){
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书籍！");
            return ;
        }
        //2.是否被借出
        Book book = bookList.getBook(i);
        if(book.isBorrowed){
            System.out.println("此书籍已经借出!");
        }else {
            book.isBorrowed = true;
            System.out.println("借阅成功!");
        }
    }
}
