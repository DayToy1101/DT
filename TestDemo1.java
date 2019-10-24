public class TestDemo1 {
    //青蛙跳台阶，一次可以跳一个台阶或两个台阶
    public static void main(String[] args) {
        int ret=jump(5);
        int ret2=jump2(5);
        System.out.println(ret);
        System.out.println(ret2);
    }
    //递归
    public static int jump(int n) {
        if (n == 1) {
            return 1;
        }if (n == 2) {
            return 2;
        }
        return jump(n - 1) + jump(n - 2);
    }//非递归
    public static int jump2(int n){
        if(n==1){
            return 1;
        }if(n==2){
            return 2;
        }
        int f1=1;
        int f2=2;
        int f3=1;
        for(int i=3;i<=n;i++){
            f3=f2+f1;
            f1=f2;
            f2=f3;
        }
        return f3;
    }
    //求斐波那契数的第n项
    /*public static void main(String[] args) {
        System.out.println(fib2(4));
    }
    //递归
    public static int fib(int n) {
        if(n==1||n==2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
    //非递归
    public static int fib2(int n) {
        int f1=1;
        int f2=1;
        int f3=1;
        for(int i=3;i<=n;i++){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }*/
    //求一个整数的每一位数字相加之和
   /* public static void main(String[] args) {
        int ret;
        ret=numSum(1234);
        System.out.println(ret);
    }
    public static int numSum(int n) {
        if(n<10){
            return n;
        }
        return n%10+numSum(n/10);
    }*/
   //顺序打出一个整数的每一位
   /* public static void main(String[] args) {
        num(1234);
    }
    public static void num(int n){
        if(n>9){
            num(n/10);
        }
        System.out.println(n%10);
    }*/
   //求1+2+3+……+n的和
   /*
   public static void main(String[] args) {
       int ret;
       ret=Sum(5);
       System.out.println(ret);
   }
   public static int Sum(int n){
        if(n==1) {
            return 1;
        }
        return n+Sum(n-1);
    }*/
}
