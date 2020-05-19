import java.util.*;

public class GoUpstairs {
    public int countWays(int n) {
        int x = 1;
        int y = 2;
        int z = 4;
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return x;
        }
        if(n == 2){
            return y;
        }
        if(n == 3){
            return z;
        }
        for(int i = 4;i <= n;i++ ){
            int temp = ((z+y)%1000000007+x)%1000000007;
            x=y;
            y=z;
            z=temp;
        }
        return z;
    }
}