import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int temp = m*(m-1)+1;
            StringBuffer str = new StringBuffer();
            for(int i = 0;i<m;i++){
                if(i==m-1){
                    str.append(temp);
                }else{
                    str.append(temp+"+");
                }
                temp += 2;
            }
            System.out.println(str);
        }
    }
}