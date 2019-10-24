public class TestDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        int max=maxArr(arr);
        int min=minArr(arr);
        int avg=avgArr(arr);
        reverse(arr);
        change(arr);
        System.out.println(max);
        System.out.println(min);
        System.out.println(avg);
    }
    //将奇数放在偶数之前
    public static void change(int[] a){
        int left=0;
        int tmp;
        int right=a.length-1;
        while(left<right){
            if(left<right&&a[left]%2!=0){
                left++;
            }if(left<right&&a[right]%2==0){
                right--;
            }if (left<right){
                tmp=a[right];
                a[right]=a[left];
                a[left]=tmp;
            }
        }
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
        }
        System.out.println("\n");
    }
    //逆置数组
    public static void reverse(int[] a){
        int i=0;
        int len=a.length;
        int tmp=0;
        while(i<a.length/2) {
            tmp=a[len-1];
            a[len-1]=a[i];
            a[i]=tmp;
            i++;
            len--;
        }
        for(i=0;i<a.length;i++){
            System.out.print(a[i] );
        }
        System.out.println("\n");
    }
    //平均值
    public static int avgArr(int[] a){
        int[] ret=new int[a.length];
        int avg=0;
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        avg=sum/a.length;
        return avg;
    }
    //最小值
    public static int minArr(int[] a){
        int min=a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]<min){
                min=a[i];
            }
        }
        return min;
    }
    //最大值
    public static int maxArr(int[] a){
        int max=0;
        for(int i=0;i<a.length;i++){
            max=a[0];
            if(a[i]>max){
                max=a[i];
            }
        }
        return max;
    }
    //我们实现一个自己版本的数组转字符串
   /* public static void main(String[] args) {
        int[] arr={1,2,3};
        String ret = toString(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(ret);
        }
    }
    public static String toString(int[] array){
        String ret=" ";
        for(int i=0;i<array.length;i++){
            ret += array[i];
        }
        return ret;
    }*/
    //写一个方法, 将数组中的每个元素都 * 2
    /*public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] ret=mul(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(ret[i]);
        }
    }

    public static int[] mul(int[] arr1) {
        int[] arr2=new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            arr2[i] = arr1[i]*2;
        }
        return arr2;
    }*/
}
