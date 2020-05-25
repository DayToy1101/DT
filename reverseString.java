import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            StringBuffer s = new StringBuffer();
            for(int j = arr.length-1;j >= 0;j--){
                s.append(arr[j]);
                if(j!=0){
                    s.append(" ");
                }
            }
            System.out.printf(s.toString());
        }
    }
}