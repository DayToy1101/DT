import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int n=sc.nextInt();
        int count=0;
        int i=32;
        while(n!=0){
            int num=n%2;
            if(num==1) {
                count++;
            }
            n>>=1;
        }
        System.out.println(count);
    }
}
