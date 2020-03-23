import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> p = new ArrayList<>();
        if(k<=0||k>input.length){
            return p;
        }
        for(int i = 0;i<input.length;i++){
            p.add(input[i]);
        }
        PriorityQueue<Integer> ret = new PriorityQueue<>(p);
        ArrayList<Integer> s=new ArrayList<>(k);
        while(k>0){
            s.add(ret.peek());
            ret.poll();
            k--;
        }
        return s;
    }
}