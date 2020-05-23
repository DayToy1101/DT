import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for(int i = 0;i < n;i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            stick(n,arr);
        }
    }
    //判断进行删除操作还是添加操作
    public static void stick(int n,int[][] arr){
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(arr[i][0]==1){
                array.add(arr[i][1]);
            }else{
                array.remove(new Integer(arr[i][1]));
            }
            if(can(array)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    //判断是否可以组成简单多边形
    public static boolean can(ArrayList<Integer> array){
        int len = array.size();
        for(int i = 0;i < len;i++){
            int tmp = array.remove(i);
            int sum = 0;
            for(int j = 0;j < len-1;j++){
                sum += array.get(j);
            }
            //如果有三条变，任意两边之和大于第三边才可以组成
            //判断剩余len-1条边之和是否大于任意一边
            if(sum <= tmp){
                array.add(i,tmp);
                return false;
            }
            array.add(i,tmp);
        }
        return true;
    }
}