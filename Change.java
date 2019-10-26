public class Change {
    public static void main(String[] args) {
        int[] arr={23,45};
        show(swap(arr));
    }
    public static int[] swap(int[] a){
        int[] ret=a;
        int tmp=ret[0];
        ret[0]=ret[1];
        ret[1]=tmp;
        return ret;
    }
    public static void show(int[] a){
        for(int i=0;i<a.length;i++){
            System.out.print("  "+a[i]);
        }
        System.out.println("\n");
    }
}
