public static void main(String[] args) {
        String arr="hello -34";
        int ret=myAtoi(arr);
        System.out.println(ret);
    }
    public static int myAtoi(String str) {
        if(str==null||str.length()==0){
            return 0;
        }
        char[] nums=str.toCharArray();
        int len = str.length();
        int tmp=1;
        long ans=0;
        int i = 0;
        //过滤掉空格
        while(i<len&&nums[i]==' '){
            i++;
        }
        //判断正负号
        if(i<len&&nums[i]=='-'){
            i++;
            tmp=-1;
        }else if(i<len&&nums[i]=='+'){
            i++;
        }
        //排除不是数字字符的情况
        while(i<len&&nums[i]>='0'&&nums[i]<='9'){
            if(ans!=(int)ans) {
                return (tmp==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;//判断是否越界
            }
            ans = ans*10 + (int) (nums[i++]-'0');
        }
        if(ans!=(int)ans) {
            return (tmp==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;//判断是否越界
        }
        return (int)(ans*tmp);
    }