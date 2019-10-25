public class Demo1 {
    public static void main(String[] args) {
        //比较3和4的大小，返回较大的数
        System.out.println("The maximum between 3 and 4 is " + max(3,4));
        //比较3.0和5.4的大小，返回较大的数
        System.out.println("The maximum between 3.0 and 5.4 is " + max(3.0,5.4));
        //比较3.0，5.4和10.14三个数的大小，并返回最大值
        System.out.println("The maximum between 3.0,5.4 and 10.14 is " + max(3.0,5.4,10.14));
    }
    //使用三个max方法的重载
    public static int max(int num1,int num2){
        if(num1<num2){
            return num2;
        }else{
            return num1;
        }
    }
    public static double max(double num1,double num2){
        if(num1<num2){
            return num2;
        }else{
            return num2;
        }
    }
    public static double max(double num1,double num2,double num3){
        //调用第二个max方法先比较前两个数的大小，再用前两个中较大的数和的第三个数比较
        return max(max(num1,num2),num3);
    }
}