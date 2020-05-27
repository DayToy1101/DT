import java.util.*;
public class Main{
    //存储所有可能的结果
    public static List<String> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0;i < N;i++){
                arr[i] = sc.nextInt();
            }
            //利用栈来模拟火车进站出站
            Stack<Integer> s = new Stack<>();
            trainOut(arr,0,s,"",0);
            //对结果进行排序
            Collections.sort(list);
            for(String str:list){
                System.out.println(str);
            }
        }
    }
    //i：表示入栈次数，j：表示出站次数，str：存储一趟进出站后的结果
    public static void trainOut(int[] arr,int i,Stack<Integer> s,String str,int j){
        if(j==arr.length){
            list.add(str);
        }
        //如果栈非空就出栈
        if(!s.empty()){
            int temp = s.pop();
            trainOut(arr,i,s,str+temp+" ",j+1);
            //恢复现场
            s.push(temp);
        }
        //如果还没入完栈就继续入栈
        if(i<arr.length){
            s.push(arr[i]);
            trainOut(arr,i+1,s,str,j);
            //恢复现场
            s.pop();
        }
    }
}