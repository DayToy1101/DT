import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int x2 = sc.nextInt();
        int x3 = sc.nextInt();
        int x4 = sc.nextInt();
        int A = (x1+x3)/2;
        int B = (x2+x4)/2;
        int C = (x4-x2)/2;
        if((x1+x3)%2==0&&(x2+x4)%2==0&&(A+B)==x3){
            System.out.println(A+" "+B+" "+C);
        }else{
            System.out.println("No");
        }
    }
}