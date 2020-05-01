import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < n;i++){
                map.put(sc.nextInt(),i);
            }
            int x = sc.nextInt();
            System.out.println(map.getOrDefault(x,-1));
        }
    }
}