public class Palindrome{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num = sc.nextInt();
        boolean flag=isPalindrome(num);
        System.out.println(flag);
    }
    //判断一个数是否是回文数
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int cur=0;
        int num=x;
        while(num!=0){
            cur=cur*10+num%10;
            num=num/10;
        }
        return cur==x;
    }
}