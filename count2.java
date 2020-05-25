import java.util.*;

public class Count2 {
    public int countNumberOf2s(int n) {
        if(n<2){
            return 0;
        }
        int round=n,weight,base=1;
        int count=0;
        while(round > 0){
            weight=round%10;
            round/=10;
            count+=round*base;
            if(weight==2)
                count+=(n%base)+1;
            if(weight>2)
                count+=base;
            base*=10;
        }
        return count;
    }
}