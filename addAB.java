import java.util.*;

public class UnusualAdd {
    public int addAB(int A, int B) {
        if(A==0){
            return B;
        }
        else if(B==0){
            return A;
        }
        int temp = 0;
        while(B!=0){
            temp=A^B;
            B=(A&B)<<1;
            A = temp;
        }
        return A;
    }
}