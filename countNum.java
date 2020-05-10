import java.util.*;
public class Main{
    private static int n;
    private static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int count = fun(0,40);
        System.out.println(count);
    }
    private static int fun(int i,int sum){
        if(i==n){
            //数组访问不能越界
            return 0;
        }
        //如果当前物体面积等于口袋所剩下的面积，则取当前物体为一种方法，若不取当前物体则继续往后取
        if(sum==arr[i]){
            return 1+fun(i+1,sum);
        }
        //若口袋面积大于当前物体，则有两种结果，一种是将当前物体装下，在看剩余的空间是否还能装下其他物品；第二种是不取当前物品，则继续往后取，口袋面积不变
        else if(sum>arr[i]){
            return fun(i+1,sum-arr[i])+fun(i+1,sum);
        }
        return fun(i+1,sum);
    }
}