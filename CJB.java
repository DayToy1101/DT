import java.util.*;
public class Main {
    private static int winA = 0;
    private static int winB = 0;
    private static HashMap<Character,Integer> A = new LinkedHashMap<Character,Integer>();
    private static HashMap<Character,Integer> B = new LinkedHashMap<Character,Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int count = n;
            sc.nextLine();
            while(count-- > 0) {
                String[] str = sc.nextLine().split(" ");
                StringBuffer sb = new StringBuffer();
                for(String s : str) {
                    sb.append(s);
                }
                Cjb(sb.toString());
            }
            int peace = n-winA-winB;
            System.out.println(winA+" "+peace+" "+winB);
            System.out.println(winB+" "+peace+" "+winA);
            if(A.size() != 0 && B.size() != 0) {
                System.out.println(Mvp(A)+" "+Mvp(B));  
            }
            if(A.size() == 0 && B.size() != 0) {
               char a = (Mvp(B) == 'B') ? 'J' :((Mvp(B) == 'C') ? 'B' : 'C');
                System.out.println(a+" "+Mvp(B));
            }
            if(A.size() != 0 && B.size() == 0) {
                char b = (Mvp(A) == 'B') ? 'J' :((Mvp(A) == 'C') ? 'B' : 'C');
                System.out.println(Mvp(A)+" "+b);
            }
        }
    }
 
    private static char Mvp(HashMap<Character,Integer> map) {
        Set<Character> set = map.keySet();
        int tmp = 0;
        char ret = 'Z';
        for(char c : set) {
            if(tmp <= map.get(c)) {
                tmp = map.get(c);
                if(ret > c) {
                    ret = c;
                }
            }
        }
        return ret;
    }
 
    private static void Cjb(String s) {
        if(s.equals("CJ") || s.equals("JB") || s.equals("BC")) {
            winA++;
            A.put(s.charAt(0),A.containsKey(s.charAt(0)) ? A.get(s.charAt(0))+1 : 1);
        }
        if(s.equals("JC") || s.equals("BJ") || s.equals("CB")) {
            winB++;
            B.put(s.charAt(1),B.containsKey(s.charAt(1)) ? B.get(s.charAt(1))+1 : 1);
        }
    }
}