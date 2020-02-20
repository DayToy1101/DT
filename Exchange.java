public class Exchange{
    public static void main(String[] args) {
        int[] num={1,2,3,4,5,6,7,8};
        int[] ret=sortArrayByParity(num);
        for (int i=0;i<ret.length;i++){
            System.out.print(ret[i]);
        }
    }
    //将奇数放在偶数之后
    public static int[] sortArrayByParity(int[] A) {
        int left=0;
        int right=A.length-1;
        int tmp;
        while(left<right){
            if(left<right&&A[left]%2==0){
                left++;
            }else if(left<right&&A[right]%2!=0){
                right--;
            }else if(left<right){
                tmp=A[left];
                A[left]=A[right];
                A[right]=tmp;
            }
        }
        return A;
    }
}