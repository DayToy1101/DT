public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String ret=toLowerCase(str);
        System.out.println(ret);
    }
    public static String toLowerCase(String str) {
        if (str != null) {
            char[] ch = str.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] >= 'A' && ch[i] <= 'Z') {
                    ch[i] += 32;
                }else{
                    continue;
                }
            }
            return (new String(ch));
        }
        return null;
    }
}