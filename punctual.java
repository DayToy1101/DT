import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            if(String.valueOf(N*N).endsWith(String.valueOf(N))){
                System.out.println("Yes!");
            }else{
                System.out.println("No!");
            }
        }
    }
}