import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(isRight(str));
        }
    }
    public static String isRight(String str){
        if(str.length()<=8){
            return "NG";
        }
        boolean f1 = false,f2 = false,f3 = false,f4 = false;
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
                f1 = true;
            }
            if(str.charAt(i)>='a' && str.charAt(i)<='z'){
                f2 = true;
            }
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                f3 = true;
            }
            if(str.charAt(i)<'a' || str.charAt(i)>'z'||
              str.charAt(i)<'A' || str.charAt(i)>'Z'||
              str.charAt(i)<'0' || str.charAt(i)>'9'){
                
                f4 = true;
            }
        }
        int count = 0;
        if(f1){
            count++;
        }
        if(f2){
            count++;
        }
        if(f3){
            count++;
        }
        if(f4){
            count++;
        }
        if(count < 3){
            return "NG";
        }
        for(int i = 3;i < str.length()/2;i++){
            for(int j = 0;j < str.length()-i;j++){
                String str1=str.substring(j,j+i);
                String str2=str.substring(j+i,str.length());
                if(str2.contains(str1))
                    return "NG";
            }
        }
        return "OK";
    }
}