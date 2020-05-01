import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String IP = sc.nextLine();
            String TEN = sc.nextLine();
            System.out.println(IpToTen(IP));
            TenToIp(TEN);
        }
    }
    public static long IpToTen(String ip){
        String[] ten = ip.split("\\.");
        long n = Long.parseLong(ten[0]);;
        for(int i = 1;i <ten.length;i++){
            n = n << 8;
            n += Long.parseLong(ten[i]);
        }
        return n;
    }
    private static void TenToIp(String p) {
        long temp=Long.parseLong(p);
        String ip=Long.toBinaryString(temp);
        StringBuilder sb=new StringBuilder();
        if(ip.length()<32){
            for(int i=0;i<(32-ip.length());i++){
                sb.append(0);
            }
            sb.append(ip);
        }else if(ip.length()==32){
            sb.append(ip);
        }
        for(int i=0;i<sb.length()-8;i=i+8){
            System.out.print(Integer.parseInt(sb.substring(i,i+8),2)+".");
        }
        System.out.println(Integer.parseInt(sb.substring(sb.length()-8,sb.length()),2));
    }
}