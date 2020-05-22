import java.util.*;

public class Replacement {
    public String replaceSpace(String iniString, int length) {
        // write code here
        if(length == 0){
            return iniString;
        }
        StringBuffer str = new StringBuffer();
        //String[] arr = iniString.split(" ");
        for(int i = 0;i < length;i++){
            if(iniString.charAt(i) ==' '){
                str.append("%20");
            }else{
                str.append(iniString.charAt(i));
            }
        }
        return str.toString();
    }
}