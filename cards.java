import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int T = sc.nextInt();
            for(int i = 0;i<T;i++){
                int n = sc.nextInt();
                int k = sc.nextInt();
                ArrayList<Integer> cards = new ArrayList<>();
                ArrayList<Integer> cd1 = new ArrayList<>();
                ArrayList<Integer> cd2 = new ArrayList<>();
                for(int j = 0;j < 2*n;j++){
                    cards.add(sc.nextInt());
                }
                Collections.reverse(cards);
                for(int x = 0;x < k;x++){
                    cd1.clear();
                    cd2.clear();
                    for(int j = 0;j < n;j++){
                        cd1.add(cards.get(j));
                    }
                    for(int j = n;j < 2*n;j++){
                        cd2.add(cards.get(j));
                    }
                    cards.clear();
                    for(int j = 0;j < n;j++){
                        cards.add(cd1.get(j));
                        cards.add(cd2.get(j));
                    }
                }
                Collections.reverse(cards);
                System.out.println(cards.toString().replace("[","").replace("]","").replace(",",""));
            }
        }
    }
}