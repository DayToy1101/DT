import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int cout = 0;
        while(x!=0&&cout<=300000){
            x=((x<<1)+1)%1000000007;
            cout++;
        }
        int ret = (cout+2)/3;
        System.out.println(ret>100000?-1:ret);
    }
}