import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int sum1 = getSum(num);
            int sum2 = getSum((int)Math.pow(num,2));
            System.out.println(sum1+" "+sum2);
        }
    }
    public static int getSum(int num){
        if(num==0){
            return 0;
        }
        int sum = 0;
        while(num!=0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}