import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> map = new HashMap<>();
        while(sc.hasNext()){
            String str = sc.nextLine();
            int rows = sc.nextInt();
            String[] arr = str.split("\\");
            String s = arr[arr.length-1];
            if(s.length()>16){
                s=s.substring(s.length()-16,s.length());
            }
            String key = s+" "+rows;
            int value = 1;
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,value);
            }
        }
        int count = 0;
        for(String ret:map.keySet()){
            count++;
            if(count > (map.keySet().size()-8)){
                System.out.println(ret+" "+map.get(ret));
            }
        }
    }
}