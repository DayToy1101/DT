import com.sun.media.sound.JARSoundbankReader;

public class Sort {
    /**
    *直接插入排序
    */
    public static void insertSort(int[] array){
        for(int i = 1;i < array.length;i++){
            int key = array[i];
            int end = i-1;
            while(end >= 0 && array[end] > key){
                array[end+1] = array[end];
                end--;
            }
            array[end+1] = key;
        }
    }
    /**
     * 希尔排序
     */
    public static void shellSort(int[] array){
        int gap = array.length;
        while(gap >1){
            gap = gap/3+1;
            for(int i = gap;i < array.length;i++){
                int key = array[i];
                int end = i- gap;
                while(end >= 0 && key < array[end]){
                    array[end + gap] = array[end];
                    end -= gap;
                }
                array[end+gap] = key;
            }
        }
    }
    /**
     * 选择排序
     */
    public static void selectSort(int[] array){
        for(int i = 0;i <array.length;i++){
            int maxPos = 0;
            for(int j = 1;j <array.length-i;j++){
                if(array[j] > array[maxPos]){
                    maxPos = j;
                }
            }
            if(maxPos != array.length-1-i){
                swap(array,maxPos,array.length-1-i);
            }
        }
    }
    /**
     * 选择排序的优化---》双向选择
     * 一次查找可以找到最大的也可以找到最小的
     */
    public static void selectSort2(int[] array){
        int begin = 0;
        int end = array.length-1;
        while (begin < end){
            int minPos = begin;
            int maxPos = begin;
            int index = begin + 1;
            while(index <= end){
                if(array[minPos] > array[index]){
                    minPos = index;
                }
                if(array[maxPos] < array[index]){
                    maxPos = index;
                }
                index++;
            }
            if(maxPos != end){
                swap(array,maxPos,end);
            }
            if(minPos == end){
                minPos = maxPos;
            }
            if(minPos != begin){
                swap(array,minPos,begin);
            }
            begin ++;
            end --;
        }
    }
    /**
     * 交换函数
     */
    private static void swap(int[] arr,int n,int m){
        int tmp = arr[n];
        arr[n] = arr[m];
        arr[m] = tmp;
    }
    /**
     * 向下调整
     */
    private static void shiftDown(int[] array,int parent,int size){
        int child = parent*2+1;
        while(child < size){
            if(child+1 < size && array[child] < array[child+1]){
                child += 1;
            }
            if(array[child] > array[parent]){
                swap(array,child,parent);
                parent = child;
                child = parent*2+1;
            }else {
                break;
            }
        }
    }
    /**
     * 堆排序
     * 1、建堆，升序---->大堆；降序---->小堆
     */
    public static void heapSort(int[] array){
        //1、建堆
        //找到第一个非叶子节点
        int lastLeaf = (array.length-2)>>1;
        for(int root = lastLeaf;root >= 0;root--){
            shiftDown(array,root,array.length);
        }
        //2、利用堆删除的思想进行排序
        int end = array.length-1;
        while(end >= 0){
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }
    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array){
        boolean isChenge = false;
        for(int i = 0;i <array.length;i++){
            isChenge = false;
            for(int j = 1;j <array.length-i;j++){
                if(array[j-1] > array[j]){
                    swap(array,j,j-1);
                    isChenge = true;
                }
            }
            if(!isChenge){
                return;
            }
        }
    }
    /**
     * 快速排序
     */
    private static void quickSort(int[] array){
        int left = 0;
        int right = array.length;
        quickSort(array,left,right);
    }
    public static void quickSort(int[] array,int left,int right){
        if(right-left > 1){
            int div = partion(array,left,right);
            quickSort(array,left,div);
            quickSort(array,div+1,right);
        }
    }
    private static int partion(int[] array,int left,int right){
        //挖坑法
        int begin = left;
        int end = right - 1;
        int key = array[end];
        while(begin < end){
            while(begin < end && array[begin] <= key){
                begin++;
            }
            if(begin < end){
                array[end--]=array[begin];
            }
            while (begin <end && array[end] > key){
                end--;
            }
            if (begin <end){
                array[begin++] = array[end];
            }
        }
        array[begin] = key;
        return begin;
    }
    /**
     * 归并排序
     */
    public static void mergeSort(int[] array){

    }
    public static void mergeSort(int[] array,int left,int right,int[] temp){
        if(right - left >1){
            int mid = left + ((right - left)>>1);
            mergeSort(array,left,mid,temp);
            mergeSort(array,mid,right,temp);
            mergeData(array,left,mid,right,temp);
           System.arraycopy(temp,left,array,left,right-left);
        }
    }

    private static void mergeData(int[] array, int left, int mid, int right, int[] temp) {
        int index = left;
        int begin1 = left,end1 = mid,begin2 = mid,end2 = right;
        while(begin1 < end1 && begin2 <end2){
            if(array[begin1] <= array[begin2]){
                temp[index++] = array[begin1++];
            }else {
                temp[index++] = array[begin2++];
            }
        }
        while(begin1 <end1){
            temp[index++] = array[begin1++];
        }
        while(begin2 < end2){
            temp[index++] = array[begin2++];
        }
    }

    /**
     *打印序列
     */
    public static void print(int[] array){
        for(int i = 0;i < array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {5,2,4,1,3};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //selectSort2(array);
        //heapSort(array);
        //bubbleSort(array);
        //quickSort(array);
        print(array);
    }
}
