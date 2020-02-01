public class Operation {
    public static void main(String[] args) {
        Calculator cal=new Calculator();
        cal.num1=4;
        cal.num2=6;
        int sum= Calculator.numSum(cal.num1,cal.num2);
        System.out.println(sum);
        int sub= Calculator.numSub(cal.num1,cal.num2);
        System.out.println(sub);
        int mul= Calculator.numMul(cal.num1,cal.num2);
        System.out.println(mul);
        double div= Calculator.numDiv(cal.num1,cal.num2);
        System.out.println(div);
    }
    static class Calculator{
        int num1;
        int num2;
        public static int numSum(int a,int b){
            int sum;
            sum=a+b;
            return sum;
        }
        public static int numSub(int a,int b){
            int sub;
            if(a>b){
                sub=a-b;
            }else {
                sub=b-a;
            }
            return sub;
        }
        public static int numMul(int a,int b){
            int mul=a*b;
            return mul;
        }
        public static double numDiv(double a,double b){
            double div=a/b;
            if(b!=0){
                if(a!=0){
                    return div;
                }else{
                    return 0;
                }
            }else{
                return -1;
            }
        }
    }
}
