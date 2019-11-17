import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.StrictMath.sqrt;

public class TestDem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] ch=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ch[i][j]=sc.nextInt();
            }
        }
        int k=sc.nextInt();
        /*int n=sc.nextInt();
        int[][] ch = new int[n][];
        for(int i=0;i<n;i++){
            for(int j=0;j<3;j++){
                ch[i][j] = sc.nextInt();
            }
        }
        int d=sc.nextInt();
        int ret=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<3;j++){
                ret+=sqrt(pow((ch[i][j]-ch[i-1][j]),2));
            }
        }
        System.out.println(ret);*/
       /* Scanner sc=new Scanner(System.in);
        int[][] ch={{1,2,3,4,5},{14,15,16,17,6},{13,20,19,18,7},{12,11,10,9,8}};
        System.out.println();
        int r=sc.nextInt();
        int c=sc.nextInt();
        System.out.println(ch[r-1][c-1]);*/
        /*System.out.println("请输入一个整数：");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("请输入a：");
        int a=sc.nextInt();
        System.out.println("请输入b：");
        int b=sc.nextInt();
        System.out.println("请输入c：");
        int c=sc.nextInt();
        int count=0;
        for(int i=1;i<=n;i++){
            if(i%a!=0&&i%b!=0&&i%c!=0){
                count++;
            }
        }
        System.out.println(count);*/
        /*Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个数：");
        int n=sc.nextInt();
        int count=0;
        for(int i=1;i<=n;i++){
            if(i%10!=2&&i/10!=2){
                count++;
            }
        }
        System.out.println(count);*/
    }
   /* public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        short[] ch={'h','e','l','l','o'};
        for(int i=0;i<ch.length;i++){
            if(ch[i]==97||ch[i]==101||ch[i]==105||ch[i]==111||ch[i]==117){
                System.out.println((char)ch[i]);
                return;
            }
        }
    }*/
}
