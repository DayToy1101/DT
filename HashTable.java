import java.util.Scanner;

public class HashTable {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] f = new int[N+1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2;i < N;i++){
            f[i] = f[i-1]+f[i-2];
        }
        int num = N;
        int ret = 0;
        for(int i = 1; i < N;i++){
            if((num>f[i-1])&&(num<f[i])){
                ret = (num-f[i-1])<(f[i]-num)?(num-f[i-1]):(f[i]-num);
                break;
            }
        }
        System.out.println(ret);
    }
}
