import java.util.Stack;

public class Sort {

    /**
     * 直接插入排序
     */

    private static void insertSort(int[] array){
        //直接插入排序
        for(int i = 1;i< array.length;i++){
            //1、找待插入元素在前面已排好序部分的位置
            int key = array[i];
            int end = i-1;
            //待插入元素为最小元素的情况
            while(end >= 0 && key<array[end]){
                array[end+1] = array[end];
                end--;
            }
            array[end+1] = key;
        }
    }

    /**
     * 希尔排序
     */

    private static void shellSort(int[] array){
        //希尔排序
        int gap = array.length;
        while(gap>1){
            gap = gap/3+1;
            for(int i = gap;i< array.length;i++) {
                //1、找待插入元素在前面已排好序部分的位置
                int key = array[i];
                int end = i - gap;
                //待插入元素为最小元素的情况
                while (end >= 0 && key < array[end]) {
                    array[end + gap] = array[end];
                    end -= gap;
                }
                array[end + gap] = key;
            }
        }
    }

    /**
     * 选择排序
     */

    private static void selectSort(int[] array){
        //选择排序
        for(int i = 0;i < array.length-1;i++){
            int maxPos = 0;
            for(int j = 1;j < array.length - i;j++){
                if(array[j]>array[maxPos]){
                    maxPos = j;
                }
            }
            //如果最大元素在它应该在的位置，不需要交换
            if(maxPos!=array.length-1-i){
                swap(array,maxPos,array.length-1-i);
            }
        }
    }
    private static void selectSortOP(int[] array){
        //[begin,end]左右都可以取到
        int begin = 0;
        int end = array.length - 1;
        while(begin < end){
            //一趟选择，既可以找到最大的元素位置，也可以找到最小的元素位置
            //minPos和maxPos都是从前往后找，起始位置都应该是begin
            int maxPos = begin;
            int minPos = begin;
            int index = begin+1;
            while(index<=end){
                if(array[index]>array[maxPos]){
                    maxPos = index;
                }
                if(array[index]<array[minPos]){
                    minPos = index;
                }
                ++index;
            }
            if(maxPos!=end){
                swap(array,maxPos,end);
            }
            //如果最小元素刚好在区间的最后一个位置，必须要更新minPos
            if(minPos == end){
                minPos = maxPos;
            }
            if(minPos!=begin){
                swap(array,minPos,begin);
            }
            begin++;
            end--;
        }
    }

    private static void swap(int[] arr,int n,int m){
        int tmp = arr[n];
        arr[n] = arr[m];
        arr[m] = tmp;
    }

    /**
     * 堆排序：
     * 1、建堆；升序-->大堆，降序-->小堆
     *      a、找堆的倒数第一个非叶子节点 最后一个叶子：size-1；它的双亲：（（size-1）-1)>>1====>(size-2)>>1;
     *      b、从倒数第一个非叶子节点的位置开始向下调整，一直向前调整到根节点的位置上为止
     * 2、利用堆删除的思想来进行排序--->用堆顶元素与堆中的最后一个元素进行交换，将堆中的元素减少一个，在将堆顶元素向下调整
     *
     */
    //向下调整
    public static void shiftDown(int[] array,int parent,int size){
        int child = parent*2+1;
        while(child<size){
            //找左右孩子中较大的孩子
            if(child+1<size && array[child+1]>array[child]){
                child+=1;
            }
            //检测双亲是否比比较大的孩子小
            if(array[child]>array[parent]){
                swap(array,child,parent);
                parent = child;
                child = parent*2+1;
            }else{
                break;
            }
        }
    }
    public static void heapSort(int[] array){
        //1、建堆
        //找倒数第一个非叶子节点
        int lastLeaf =(array.length-2)>>1;

        //从lastLeaf的位置到根root的位置上不断进行向下调整
        for(int root = lastLeaf;root>=0;root--){
            shiftDown(array,root,array.length);
        }
        //2、利用堆删除的思想进行排序
        int end = array.length-1;
        while(end>=0){
            swap(array,0,end);
            shiftDown(array,0,end);
            end--;
        }
    }

    /**
     * 快速排序
     */

    public static void quickSort(int[] array,int left,int right){
        //快速排序
        //[left,right)
        if(right - left > 1){
            //说明该区间至少有两个元素
            int div = partion3(array,left,right);//按照基准值对[left,right)区间在进行分割

            //递归排基准值的左半侧
            quickSort(array,left,div);

            //递归排基准值的右半侧
            quickSort(array,div+1,right);
        }
    }
    private static int partion(int[] array,int left,int right){
        int mid = getIndexOfMiddle(array,left,right);//使用三数取中法，降低取的基准值为极值的概率
        swap(array,mid,right-1);
        int key = array[right-1];//基准值
        int begin = left;
        int end = right-1;
        while(begin<end) {
            /*
            注意数组越界的判断
             */
            //1、让begin从前往后找，找比基准值大的数字
            while (array[begin] <= key && begin < end) {
                begin++;
            }
            //2、让end从后往前找比基准值小的元素
            while (array[end] >= key && begin < end) {
                end--;
            }
            if (begin < end) {
                swap(array, begin, end);
            }
        }
        //如果基准值刚好在他所应该在的位置上，就不需要交换
        if(array[begin] != key){
            swap(array,begin,right-1);
        }
        return begin;
    }
    private static int partion2(int[] array,int left,int right){
        //挖坑法找基准值
        int begin = left;
        int end = right - 1;
        int key = array[end];
        while(begin < end){
            //1、让begin从前往后找，找比基准值大的数字
            while(begin < end && array[begin] <= key){
                begin++;
            }
            //找到了一个比基准值大的元素，用该元素添end位置的坑
            if(begin<end){
                array[end--] = array[begin];
            }
            //2、让end从后往前找比基准值小的元素
            while(begin < end && array[end] >= key){
                end--;
            }
            //找到了一个比基准值小的元素，用该元素添begin位置的坑
            if(begin < end){
                array[begin++] = array[end];
            }
        }
        //循环结束后，用key填最后一个坑
        array[begin] = key;
        return begin;
    }
    private static int partion3(int[] array,int left,int right){
        int cur = left;
        int prev = cur-1;
        int key = array[right-1];
        while (cur < right){
            if(array[cur] < key && ++prev!=cur){
                swap(array,cur,prev);
            }
            ++cur;
        }
        if(++prev != right-1){
            swap(array,prev,right-1);
        }
        return prev;
    }
    //取基准值的优化
    //从区间最左侧、中间、最右侧取基准值，对这三个位置的基准值进行比较，返回比较的中间值
    private static int getIndexOfMiddle(int[] array,int left,int right){
        int mid = left+((right-left)>>1);
        if(array[left]<array[right-1]){
            if(array[mid]<array[left]){
                return left;
            }
            else if(array[mid]>array[right-1]){
                return right-1;
            }
            else {
                return mid;
            }
        }
        else{
            if(array[mid]>array[left]){
                return left;
            }
            else if(array[mid]<array[right-1]){
                return right-1;
            }
            else {
                return mid;
            }
        }
    }
    //非递归的快速排序
    public static void quickSort(int[] array){
        Stack<Integer> s = new Stack<>();
        s.push(array.length);
        s.push(0);
        while(!s.empty()){
            int left = s.pop();
            int right = s.pop();
            if(right-left >1){
                int div = partion(array,left,right);
                s.push(right);
                s.push(div+1);
                s.push(div);
                s.push(left);
            }
        }
    }

    /**
     *归并排序
     */
    private static void mergeData(int[] array,int left,int mid,int right,int[] temp){
        //[left,mid)  [mid,right)
        int index = left;
        int begin1 = left, end1 = mid, begin2 = mid, end2 = right;
        while(begin1<end1 && begin2<end2){
            if(array[begin1]<=array[begin2]){
                temp[index++] = array[begin1++];
            }else{
                temp[index++] = array[begin2++];
            }
        }
        //如果第一个区间中还有数据
        while(begin1<end1){
            temp[index++] = array[begin1++];
        }
        //如果第二个区间中还有数据
        while(begin2<end2){
            temp[index++] = array[begin2++];
        }
    }
    private static void mergeSort(int[] array,int left,int right,int[] temp){
        //归并排序
        if(right - left > 1){
            int mid = left + ((right - left)>>1);

            //[left,mid)--->左半部分
            mergeSort(array,left,mid,temp);

            //[mid,right)--->右半部分
            mergeSort(array,mid,right,temp);

            //归并
            mergeData(array,left,mid,right,temp);

            //归并结束后，有序序列存储在temp中，需要将temp中的数据拷贝到array中去
            System.arraycopy(temp,left,array,left,right-left);
        }
    }
    public static void mergeSort(int[] array){
        int[] temp = new int[array.length];
        mergeSort(array,0,array.length,temp);
    }
    //非递归的归并排序
    public static void mergeSortNor(int[] array){
        int[] temp = new int[array.length];
        int gap = 1;

        while(gap < array.length){
            for(int i = 0;i < array.length;i += gap*2){
                int left = i;
                int mid = left+gap;
                int right = mid+gap;
                if(mid > array.length){
                    mid = array.length;
                }
                if(right > array.length){
                    right = array.length;
                }
                mergeData(array,left,mid,right,temp);
            }
            System.arraycopy(temp,0,array,0,array.length);
            gap <<= 1;//gap *= 2  表示每次归并之后一组中的数据个数
        }
    }

    /**
     * 冒泡排序
     * 一趟冒泡的方式：将相邻的两个元素进行比较
     * 让大的元素往后移动
     */
    public static void bubbleSort(int[] array){
        boolean isChange = false;//用来优化冒泡----冒泡冒了一定趟数之后，可能已经有序了，后续的冒泡就不需要执行了
        //外层循环：控制的是冒泡的趟数
        for(int i  = 0;i<array.length-1;i++){
            //具体的冒泡方式
            isChange = false;
            for(int j = 1;j<array.length-i;j++){
                if(array[j-1] > array[j]){
                    swap(array,j-1,j);
                    isChange = true;
                }
            }
            if(!isChange){
                return;
            }
        }

    }

    /**
     * 计数排序
     * 场景：数据密集集中在某个范围中
     * 时间复杂度：O（N）   N：表示区间中元素的个数
     * 空间复杂度：O（M）  M：表示区间中元素种类的个数
     */

    public static void countSort(int[] array){
        //1、统计元素的范围
        int minValue = array[0];
        int maxValue = array[0];
        for(int i = 1 ;i<array.length-1;i++){
            if(array[i]>maxValue){
                maxValue = array[i];
            }
            if(array[i]<minValue){
                minValue = array[i];
            }
        }
        //2、开辟计数空间：该范围中最多包含的不同元素种类的个数
        int range = maxValue-minValue+1;
        int[] arrayCount = new int[range];

        //3、统计每个元素出现的次数
        for(int i = 0; i < array.length;i++){
            arrayCount[array[i]-minValue]++;
        }

        //4、对元素进行回收----排序
        int index = 0;
        for(int i = 0;i < range;i++){
            while(arrayCount[i]--!=0){
                array[index++] = i + minValue;
                arrayCount[i]--;
            }
        }
    }
    /**
     * 打印序列
     */

    private static void print(int[] array){
        for(int i = 0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args) {
        //int[] array={3,8,2,6,7,5,4,9};
        //insertSort(array);
        //shellSort(array);
        //selectSort(array);
        //selectSortOP(array);
        //heapSort(array);
        //quickSort(array,0,array.length);
        //mergeSort(array);
        //mergeSortNor(array);
        //bubbleSort(array);
        int[] array = {0,0,9,7,8,9,5,6,4,3,6,3,5,1,8,4};
        countSort(array);
        print(array);
    }
}
