 public static void main(String[] args) {
        char[] ch={'a','a','b','b','c','c','c'};
        System.out.println(compress(ch));
    }
    public static int compress(char[] chars) {
        if(chars.length<=1){
            return chars.length;
        }
        int index=0;//标记最后结果数组元素的下标
        int cur=1;//用来标记当前字符的个数
        chars[index]=chars[0];
        for(int i = 1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                cur++;
            }else {
                if(cur!=1){
                    //将cur的值分开存入nums数组中
                    char[] nums=String.valueOf(cur).toCharArray();
                    for (char c:nums) {
                        //遍历nums数组，将cur每一位的值按顺序存入chars数组中
                        chars[++index]=c;
                    }
                }
                //存完当前重复字符个数之后，继续往下查找chars数组中的字符
                chars[++index]=chars[i];
                cur=1;
            }
        }
        if(cur!=1){
            char[] nums=String.valueOf(cur).toCharArray();
            for (char c:nums) {
                chars[++index]=c;
            }
        }
        return index+1;
    }