public class TestDemo {
    //数组的冒泡排序
    public static void main(String[] args) {
        int[] arr={12,3,45,65,2,14,58};
        bubblingSearch(arr);
        show(arr);
    }
    public static void bubblingSearch(int[] a){
        for(int i =0;i<a.length;i++){
            for(int j=a.length-1;j>i;j--) {
                if (a[j-1] > a[j]) {
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }
    public static void show(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print("  "+a[i]);
        }
    }
    //数组二分法查找的递归调用
   /* public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int left=0;
        int right=arr.length;
        int ret=binarySearch(arr,6,left,right);
        System.out.println(arr[ret]);
    }
    public static int binarySearch(int[] array,int key,int left,int right){
        int mid=(left+right)/2;
        if(left>right){
            return -1;
        }
        if(left<right){
            mid=(left+right)/2;
            if(array[mid]==key){
                return mid;
            }
            if(array[mid]>key){
                return binarySearch(array,6,left,mid-1);
            }
            if(array[mid]<key){
                return binarySearch(array,6,mid+1,right);
            }
        }
        return mid;
    }*/
}
