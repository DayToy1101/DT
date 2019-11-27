public class TestDemo00 {
    public static void main(String[] args) {
        String str = "Hello";
        str = "h" + str.substring(1);//substring(1)提取一个子串：从1号下标开始提取子串
        System.out.println(str);
        /*反射：Java的自省操作
              使用 "反射" 这样的操作可以破坏封装, 访问一个类内部的 private 成员.*/
    }
    public static void main1(String[] args) {
        String str="abcdef";//直接赋值//只要是双引号引起来的内容都放在堆里的常量池中，str中存放的是abcdef的地址
        System.out.println(str);

        String str1=new String("abcdef").intern();
        System.out.println(str==str1);//true
        /*inter()方法：手动入池
            1、如果常量池中存在；将常量池当中的字符串的地址返回给当前字符串的引用
            2、如果常量池当中不存在；则在常量池当中生成一个字符串，并将该字符串的地址返回给当前的引用*/

        String str2=new String("abcdef");//在堆里new一个对象直接引用常量池中的abcdef，而str2中存放的是对象的地址
        System.out.println(str2);

        char[] array={'a','b','c','d','e','f'};
        String str3=new String(array);//在堆中将数组再重新拷贝一份给str3
        System.out.println(str3);

        String str4="abc"+"def";//编译期间确定拼接为abcdef

        String str5="abc"+new String("def");

        String str6="abc";
        String str7="def";
        String str8=str6+str7;

        System.out.println(str==str2);//false//比较的是它们各自里面存放的地址
        System.out.println(str2==str3);//false//比较的是地址
        System.out.println(str==str4);//true//引用的是同一个abcdef；常量池中已经有abcdef了，所以不再重新在常量池中存放abcdef
        System.out.println(str==str5);//false
        System.out.println(str==str8);//false
        //System.out.println(str.equals(str2));//true//equals比较的是他们的内容是否相同
        System.out.println("abcdef".equals(str2));
        System.out.println(str.compareTo(str2));//比较两个字符串是否相等
    }
}
