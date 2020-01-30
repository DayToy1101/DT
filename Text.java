import java.util.Scanner;
public class Text {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // scanner.hasNext()循环输入
        while(sc.hasNext()){
            String str=sc.nextLine();//输入一个字符串
            StringBuilder builder=new StringBuilder();
            //遍历输入的字符串
            for(int i=0;i<str.length();i++){
                char temp=str.charAt(i);//得到i号下标的字符
                //将builder里的内容转为字符串与i号下标的字符比较，
                // 如果builder里不包含当前i号字符则把该字符拼接到builder后面
                if(!builder.toString().contains(temp+"")){
                    builder.append(temp);
                }
            }
            System.out.println(builder.toString());
        }
    }
}
