import book.BookList;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

public class Main {
    public static User login() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的名字：");
        String name=scanner.next();
        System.out.println("请输入你的身份：（1、管理员；2、普通用户）");
        int who=scanner.nextInt();
        if(who==1){
            return new Admin(name);
        }else{
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
      BookList book=new BookList();
      while(true){
          User user=login();
          int ret=user.menu();
          user.doOperation(ret,book);
      }
    }
}
