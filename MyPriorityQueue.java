import java.util.Arrays;

interface Comp
{
    public int compare(int left,int right);
}
//按照小于的方式比较
class Less implements Comp{
    public int compare(int left,int right){
        return left - right;
    }
}
//按照大于的方式比较
class Greater implements Comp{
    public int compare(int left,int right){
        return left - right;
    }
}

//为了实现简单，假设优先级队列中放的都是int类型
public class MyPriorityQueue {
    private int[] array;
    private int size;//表示优先级队列中有效元素的个数

    Comp compare = null;

    public MyPriorityQueue(Comp com){
        //默认的构造---将其底层容量设置为11
        array = new int[11];
        compare = com;
        size = 0;
    }
    public MyPriorityQueue(int initCapacity,Comp com){
        if(initCapacity < 1){
            //标准库：会抛出一个非法参数的异常
            initCapacity = 11;
        }
        array = new int[initCapacity];
        compare = com;
        size = 0;
    }
    //标准库中没有该接口---标准库中可以采用集合来构造优先级队列
    public MyPriorityQueue(int[] arr,Comp com){
        //尝试进行优化
        array = new int[arr.length];
        for(int i = 0; i<arr.length;i++){
            array[i] = arr[i];
        }
        compare = com;
        size = arr.length;
        //将array中的元素调整，让其满足小堆的性质
        int lastLeaf = (array.length-2)>>1;
        for(int root = lastLeaf;root>=0;root--){
            shiftDown(root);
        }
    }
    //获取堆顶元素
    int peek(){
        //标准库中，如果优先级队列是空，无法获取堆顶元素，因此返回null
        return array[0];
    }
    //
    boolean offer(int x){
        if(size>=array.length){
            grow();
        }
        array[size++] = x;
        shiftUp(size-1);
        return true;
    }
    //每次删除的是堆顶的元素
    int poll(){
        int ret = array[0];
        swap(0,size-1);
        size--;
        shiftDown(0);
        return ret;
    }

    boolean isEmpty(){
        return 0 == size;
    }

    int size(){
        return size;
    }

    void clear(){
        size = 0;
    }
    //向上调整
    private void shiftUp(int child){
        int parent = (child-1)>>1;

        while(parent > 0){
            //if(array[child] > array[parent]) {
            if(compare.compare(array[child],array[parent])>0){
                swap(child, parent);
                child = parent;
                parent = (child - 1) >> 1;
            }else{
                break;
            }
        }
    }
    //parent表示本次需要调整的节点的下标
    //调整以parent为根的二叉树
    //注意：调整之前，一定要保证parent的左右子树已经满足小堆的性质
    //如果要检测parent是否满足小堆的性质，只需要用parent与其孩子进行比较
    //
    private void shiftDown(int parent){
        //使用child标记parent的较小的孩子
        //默认情况下先让其标记其左孩子，因为parent可能只有左孩子而没有右孩子
        int child = parent*2+1;

        while(child < size) {//保证左孩子存在
            //找parent中较小的孩子
            //再用左右孩子进行比较时，必须要保证右孩子存在
            //if (child+1<size && array[child + 1] < array[child]) {
            if(child+1<size&&compare.compare(array[child+1],array[child])<0){
                child += 1;
            }

            //检测较小的孩子是否比parent小
            //if (array[child] < array[parent]) {
            if(compare.compare(array[child],array[parent])<0){
                //说明parent不满足小堆的性质
                swap(parent, child);
                //可能会导致子树不满足小堆的性质
                //继续向下调整
                parent = child;
                child = parent * 2 + 1;
            } else {
                return;
            }
        }
    }
    //扩容--参考顺序表
    //只是模拟标准库中优先级队列扩容的一部分
    private void grow(){
        int oldCapacity = array.length;
        int newCapacity = oldCapacity + ((oldCapacity<64)?(oldCapacity+2):(oldCapacity>>1));
        array = Arrays.copyOf(array,newCapacity);
    }

    private void swap(int parent,int child){
        int temp = array[parent];
        array[parent] = array[child];
        array[child] = temp;
    }

    public static void main(String[] args) {
        int[] array = {5,3,7,1,4,6,8,0,2};
        MyPriorityQueue mp = new MyPriorityQueue(array,new Greater());
        mp.offer(9);
        System.out.println(mp.peek());

        mp.offer(-1);
        System.out.println(mp.peek());

        mp.poll();

        System.out.println(mp.peek());
        System.out.println(mp.size());

        mp.clear();
        if(mp.isEmpty()){
            System.out.println("空");
        }else{
            System.out.println("非空");
        }
    }
}