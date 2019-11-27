public class Test01 {
    public static void main(String[] args) {
        String str = "1abcd23";
        System.out.println(isNumber(str)?"字符串有数字组成！":"字符串不是由数组组成！");
    }
    public static boolean isNumber(String str){
        char[] data=str.toCharArray();
        for(int i=0;i<data.length;i++){
            if(data[i]<'0'||data[i]>'9'){
                return false;
            }
        }
        return true;
    }
}
