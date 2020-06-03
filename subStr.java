import java.util.*;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] ret = new boolean[n];
        for(int i = 0;i < n;i++){
            ret[i] = s.contains(p[i]);
        }
        return ret;
    }
}