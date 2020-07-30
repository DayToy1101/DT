public class FourSort {
    /**
     * 插入排序
     */
    public static void inserSort(int[] array){
        for(int i = 1;i < array.length;i ++){
            int key = array[i];
            int end = i-1;
            while(end>=0 && array[end] > key){
                array[end+1] = array[end];
                end--;
            }
            array[end+1] = key;
        }
    }
    /**
     * 希尔排序
     */
    public static  void shellSort(int[] array){
        int gap = array.length;
        while(gap > 1){
            gap = gap/3+1;
            for(int i = gap;i <array.length;i++){
                int key = array[gap];
                int end = i-gap;
                while(end >= 0 && array[end] > key){
                    array[end+gap] = array[end];
                    end -= gap;
                }
                array[end+gap] = key;
            }
        }
    }
    /**
     * 选择排序
     */
    public static void selectSort(int [] array){
        for(int i = 0;i <array.length;i++){
            int maxPos = 0;
            for(int j = 1;j <array.length-i;j++){
                if(array[j-1] < array[j]){
                    maxPos = j;
                }
            }
            if(maxPos != array.length-1-i){
                swap(array,maxPos,array.length-1-i);
            }
        }
    }
    public static void selectSort2(int[] array){
        int begin = 0;
        int end = array.length-1;
        while(begin < end){
            int maxPos = begin;
            int minPos = begin;
            int index = begin+1;
            while(index <= end){
                if(array[maxPos] < array[index]){
                    maxPos = index;
                }
                if (array[minPos] > array[index]){
                    minPos = index;
                }
                index++;
            }
            if(maxPos != end){
                swap(array,maxPos,end);
            }
            if (minPos==end){
                minPos = maxPos;
            }
            if(minPos!=begin){
                swap(array,minPos,begin);
            }
            begin++;
            end--;
        }
    }
    /**
     * 冒泡排序
     */
    public static void bubbleSort(int[] array){
        boolean isChange = false;
        for(int i = 0;i <array.length;i++){
            isChange=false;
            for(int j = 1;j <array.length-i;j++){
                if(array[j] < array[j-1]){
                    swap(array,j,j-1);
                    isChange = true;
                }
                if (!isChange){
                    return;
                }
            }
        }
    }
    /**
     * 快速排序
     */
    public static void quickSort(int[] array,int left,int right){
        if(right - left >1){
            int div = partion(array,left,right);
            quickSort(array,left,div);
            quickSort(array,div+1,right);
        }
    }
    private static int partion(int[] array,int left,int right){
        //挖坑法
        int begin = left;
        int end = right-1;
        int key = array[end];
        while(begin < end){
            while(begin < end && array[begin] < key){
                begin++;
            }
            if (begin <end)
                array[end--] = array[begin];
            while (begin <end && array[end] > key ){
                end--;
            }
            if (begin < end){
                array[begin++] = array[end];
            }
        }
        array[begin] = key;
        return begin;
    }
    /**
     * 归并排序
     */
    public static void mergeData(int[] array,int left,int mid,int right,int[] temp){
        int index = left;
        int begin1 = left,end1 = mid,begin2 = mid,end2 = right;
        while(begin1 < end1 && begin2 <end2){
            if(array[begin1] <array[begin2]){
                temp[index++] = array[begin1++];
            }else {
                temp[index++] = array[begin2++];
            }
        }
        while (begin1 <end1){
            temp[index++] = array[begin1++];
        }
        while (begin2 <end2){
            temp[index++] = array[begin2++];
        }
    }
    public static void mergeSort(int[] array,int left,int right,int[] temp){
        if(right-left > 1){
            int mid = left +((right-left)>>1);
            mergeSort(array,left,mid,temp);
            mergeSort(array,mid,right,temp);
            mergeData(array,left,mid,right,temp);
            System.arraycopy(temp,left,array,left,right-left);
        }
    }
    private static void swap(int[] array,int m,int n){
        int tmp = array[n];
        array[n] = array[m];
        array[m] = tmp;
    }
    public static void print(int[] array){
        for(int i = 0;i <array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
