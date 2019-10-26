import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入n的值：");
        int n=scanner.nextInt();
        //打印1到n之间的素数
        for(int i=1;i<=n;i++){
            if(isPrime(i)){
                System.out.print(i+"  ");
            }
        }
        System.out.println("\n");
        int a=10;
        int b=20;
        int ret=func(a,b);
        System.out.println("最大公约数 ："+ret);
        int year=2000;
        year(year);
        mul(n);
    }
    //输出乘法口诀表
    public static void mul(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.printf("%d * %d =%d   ",i,j,i*j);
            }
            System.out.print("\n");
        }
    }
    //输出1000-2000之间的闰年
    public static void year(int year){
        int count=0;
        for(int i=1000;i<=year;i++){
            if((i%4==0)&&(i%100!=0)||(i%400==0)){
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
    //求两个数的最大公约数
    public static int func(int a,int b){
        while(a%b!=0){
            int tmp=a;
            a=b;
            b=tmp;
        }
        return b;
    }
    //判断一个数是否为素数
    public static boolean isPrime(int num){
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
