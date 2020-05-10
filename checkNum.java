import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            for(int i = 0;i < str.length();i++){
                int ch=str.charAt(i);
                if(count(ch)%2==0){
                    ch += 128;
                }
                print(ch);
            }
        }
    }
    private static int count(int n){
        int b = 1;
        int count = 0;
        for(int j = 0;j < 8;j++){
            if((n & b)== b){
                count++;
            }
            b <<= 1;
        }
        return count;
    }
    private static void print(int num){
        int b = 128;
        StringBuffer s = new StringBuffer();
        for(int i = 0;i < 8;i++){
            if((num & b) == b){
                s.append("1");
            }else{
                s.append("0");
            }
            b >>>= 1;
        }
        System.out.println(s.toString());
    }
}