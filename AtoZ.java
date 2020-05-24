import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            HashMap<String,Integer> map = new HashMap<>();
            char s = 'A';
            while(s<='Z'){
                map.put(String.valueOf(s),0);
                s++;
            }
            for(int i = 0;i < str.length();i++){
                char ch = str.charAt(i);
                if(ch>='A'&&ch<='Z'){
                    if(map.containsKey(String.valueOf(ch))){
                        map.put(String.valueOf(ch),map.get(String.valueOf(ch))+1);
                    }
                }
            }
            for(String key:map.keySet()){
                System.out.println(key+":"+map.get(key));
            }
        }
    }
}