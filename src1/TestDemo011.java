import java.util.Scanner;
class MyException extends Exception{
    public MyException(String str){
        super(str);
    }
}
public class TestDemo02 {
    public static void funcException()throws MyException{
        int a=10;
        if(a==10){
            throw new MyException("a==10");
        }
    }
    public static void main(String[] args) {
        try{
            funcException();
        }catch (MyException e){
            e.printStackTrace();
        }
    }
    public static int div(int a,int b)throws ArithmeticException{
        if(b==0){
            throw new ArithmeticException();
        }
        return a/b;
    }
    public static void main2(String[] args) {
        try{
            int a=div(10,0);
            System.out.println(a);
        }catch(ArithmeticException e){
            e.printStackTrace();
        }

    }
    public static void main1(String[] args) {
        int[] array=null;
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        try{
            System.out.println(array.length);//空指针异常
            System.out.println(array[100]);//数组越界异常
        }catch(NullPointerException e){
            e.printStackTrace();
            System.out.println("异常捕获");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("越界异常捕获");
        }catch(Exception e) {
            //可以捕获所有的异常
        }finally {
            sc.close();
            System.out.println("异常捕获处理");
        }
        //finally块儿是永远会被执行的
        //一般用在资源的关闭——》文件打开之后进行文件关闭
        //建议return不要放在女finally块儿中
        //因为可能会抑制catch或try当中的return语句
        System.out.println("after");
    }
}
