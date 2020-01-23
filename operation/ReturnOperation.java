package operation;

import book.Book;
import book.BookList;

public class ReturnOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("ReturnOperation");
        System.out.println("输入你要归还的图书的名称：");
        String name=sc.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书籍！");
            return ;
        }
        Book book=bookList.getBook(i);
        System.out.println("归还成功！");
    }
}
