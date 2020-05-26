import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            int count = 0;
            LinkedList<Character> list = new LinkedList<>();
            char[] str = str1.toCharArray();
            for(int i = 0;i < str.length;i++){
                list.add(str[i]);
            }
            for(int i = 0;i < str2.length();i++){
                for(int j = 0;j < list.size();j++){
                    if(str2.charAt(i)==list.get(j)){
                        list.remove(j);
                        count++;
                        break;
                    }
                }
            }
            if(count == str2.length()){
                System.out.println("Yes "+(str1.length()-count));
            }else{
                System.out.println("No "+(str2.length()-count));
            }
        }
    }
}