import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int number = sc.nextInt();//候选人数量
            String[] s = new String[number];
            Map<String,Integer> map = new HashMap<>();//存放候选人及其对应获得的票数
            for(int i = 0;i < number;i++){
                s[i] = sc.next();
                map.put(s[i],0);
            }
            int voteNum = sc.nextInt();//投票人数
            int tmp = 0;//无效票数
            for(int i = 0;i < voteNum ;i ++){
                String vote = sc.next();
                if(map.get(vote)==null){
                    tmp++;
                }else{
                    map.put(vote,map.get(vote)+1);
                }
            }
            for(String k:s){
                System.out.println(k+" : "+map.get(k));
            }
            System.out.println("Invalid : "+tmp);
        }
    }
}