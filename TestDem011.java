import java.util.Arrays;
import java.util.Scanner;

public class TestDem01 {
    public static void main(String[] args) {
        StringBuilder str=new StringBuilder("abcdef");
        str.append("gh");
        System.out.println(str);
        StringBuffer sb=new StringBuffer(" ");
        sb.append("a");
        System.out.println(sb);
    }
    //append:字符串拼接函数
    // StringBuilder生成一个字符串
    // StringBuffer和StringBuilder相比String的优点是在拼接字符串时不会产生一个新的对象,无论拼接多少次StringBuilder都只有一个对象
    //StringBuffer适用于多线程，加有synchronized修饰,采用同步处理，保证线程安全
    //StringBuilder和String都适用于单线程
    public static void main4(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        int k=sc.nextInt();
        String ret=func(str,k);
        System.out.println(ret);
    }
    private static String func(String str,int k){
        if(str==null||k<=0){
            return null;
        }
        str=reverse(str,0,k-1);
        str=reverse(str,k,str.length()-1);
        str=reverse(str,0,str.length()-1);
        return str;
    }
    private static String reverse(String str,int left,int right){
        char[] value=str.toCharArray();
        while(left<right){
            char tmp=value[left];
            value[left]=value[right];
            value[right]=tmp;
            left++;
            right--;
        }
        return new String(value);
    }
    //字符串逆置
    private static String reverse(String str){
        char[] value=str.toCharArray();
        int left=0;
        int right=value.length-1;
        while(left<right){
            char tmp=value[left];
            value[left]=value[right];
            value[right]=tmp;
            left++;
            right--;
        }
        return String.copyValueOf(value);
        //return new String(value);
    }
    public static void main3(String[] args) {
        String str="abcdef";
        System.out.println(reverse(str));
    }
    public static void main2(String[] args) {
        /*String  str="abcdefab";
        str = str.replace("ab","ly");
        //replace和replaceAll都是全部替换，返回值为String类型
        System.out.println(str);
        String str2=str.replaceFirst("ab","ly");
        */
        String str="ab,cd,ef";
        String[] strings=str.split(",");
        String[] strings1=str.split(",",2);//limit表示最多分为几组
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(strings1));
        String str2="192.169.1.1";
        String[] strings2=str2.split("\\.");//对于特殊字符需要在前面加上\\先将它转义在进行分割
        String str3="abc=def ght=gb";
        String[] strings3=str3.split(" ");
        System.out.println(Arrays.toString(strings3));
        String[] ret={};
        for (String s:strings3) {
            ret=s.split("=");
        }
        System.out.println(Arrays.toString(ret));
    }
    public static void main1(String[] args) {
        String str="Abc";
        String str2="ABc";
        String str3="Abcdef";
        String str4="def";
        System.out.println(str.compareTo(str2));
        System.out.println(str.equals(str2));
        byte[] bytes=str.getBytes();
        System.out.println(Arrays.toString(bytes));
        System.out.println(str3.contains(str4));//判断str3里是否包含str4，返回true或false
        System.out.println(str3.indexOf(str4));//判断str3里包含str4是从那个位置开始，返回下标
        System.out.println(str3.indexOf(str4,4));//表示从第四个下标开始比较查找
        System.out.println(str3.lastIndexOf(str4,3));//从后往前找,fromindex：3表示从三号位置开始从后往前找
        System.out.println(str3.startsWith("AB",2));//startsWith：判断str3是否是以AB开始，2表示从二号位置开始判断是否是AB
        System.out.println(str3.endsWith("AB"));//endsWith：判断是否以AB结束
    }
}
