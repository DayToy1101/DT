import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        for(int i = 0;i<10;i++){
            list.add(sc.nextInt());
        }
        StringBuffer str = new StringBuffer();
        //找第一个不为零的最小数作为首位
        for(int i = 1;i<list.size();i++){
            if(list.get(i)!=0){
                str.append(i);
                list.set(i,list.get(i)-1);
                break;
            }
        }
        //按照顺序从最小的数依次把所有的数字放完
        for(int i = 0;i<list.size();i++){
            if(list.get(i)!=0){
                for(int j = 0;j<list.get(i);j++){
                    str.append(i);
                }
            }
        }
        System.out.println(str.toString());
    }
}