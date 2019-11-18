package operation;

import book.Book;
import book.BookList;

public class DelOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("DelOperation");
        System.out.println("输入你要删除的图书的名称：");
        String name=sc.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书籍！");
            System.out.println("删除失败！");
            return ;
        }
        int pos=i;
        for(int j=pos;j<bookList.getSize()-1;j++){
            Book nextBook=bookList.getBook(j+1);
            bookList.setBooks(j,nextBook);
        }
        bookList.setSize(bookList.getSize()-1);
        System.out.println("删除成功！");
    }
}
