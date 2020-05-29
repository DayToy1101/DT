public class HashBucket {
    private static class Node{
        int key;
        int value;
        Node next;
        Node(int key,int value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    //哈希桶中的成员数据
    Node[] table;
    int capacity;
    int size;
    double loadFact = 0.75;
    public HashBucket(int initCap){
        capacity= initCap;
        if(initCap <10){
            capacity = 10;
        }
        table = new Node[capacity];
        size = 0;
    }
    //插入
    public int put(int key,int value){
        resize();
        //1、通过哈希函数，计算key所在的桶号
        int bucketNo = hashFunc(key);
        //2、在bucketNo桶中检测key是否存在
        //检测的方式：遍历链表
        Node cur = table[bucketNo];
        while(cur!=null){
            if(cur.key == key){
                int oldValue = cur.value;
                cur.value = value;
                return oldValue;
            }
            cur = cur.next;
        }
        //3、key不存在，将key-value的键值对插入到哈希桶中
        cur = new Node(key,value);
        cur.next = table[bucketNo];
        table[bucketNo] = cur;
        size++;
        return value;
    }
    private void resize(){
        //装载因子超过0.75时进行扩容---按照两倍的方式进行扩容
        //*10是为了避免size/capacity=0，就进不去if
        if(size*10/capacity > loadFact*10){
            Node[] newTable = new Node[capacity*2];
            int newCap = capacity * 2;
            //将table中的元素节点搬移到newTable中
            for(int i = 0;i < capacity;i++){
                Node cur = table[i];
                //将table中i号桶所对应的所有的节点插入到newTable中
                while(cur!=null){
                    table[i] = cur.next;
                    //将cur节点插入到newTable中
                    //1、计算cur在newTable中的位置
                    //int bucketNo = hashFunc(cur.key);
                    //这个方法不可以，capacity没有改变
                    int bucketNo = cur.key % newCap;

                    //2、将cur插入到newTable中
                    cur.next = newTable[bucketNo];
                    newTable[bucketNo] = cur;
                    //取table中i号桶的下一个元素节点                    cur = table[i];
                }
            }
            table = newTable;
            capacity = newCap;
        }
    }
    //将哈希桶中为key的键值对删除
    public boolean remove(int key){
        //1、通过哈希函数计算key的桶号
        int bucketNo = hashFunc(key);

        //2、在bucketNo桶中找key所对应的节点
        //找到后将该节点删除
        Node cur = table[bucketNo];
        Node prev = null;
        while(cur!=null){
            if(cur.key == key){
                //找到与key所对应的节点，将该节点删除
                if(prev == null){
                    //删除的节点刚好是第一个节点
                    table[bucketNo] =cur.next;
                }else{
                    //删除的是其他节点
                    prev.next = cur.next;
                }
                --size;
                return true;
            }else{
                prev = cur;
                cur = cur.next;
            }
        }
        return false;
    }
    //O(1)//找值为key的节点是否在桶中
    public boolean containsKey(int key){
        //1、计算key所在的桶号
        int bucketNo = hashFunc(key);
        //2、在bucketNo桶中找key
        Node cur = table[bucketNo];
        while(cur!=null){
            if(cur.key == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //O(N)
    public boolean containsValue(int value){
        //注意：哈希桶是根据key来计算哈希地址的
        //因此：找value，不能计算value在哪个桶中
        //在找value是必须遍历所有的桶
        for(int bucketNo = 0; bucketNo <capacity;bucketNo++){
            Node cur = table[bucketNo];
            while(cur!=null){
                if(cur.value == value){
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }
    public int size(){
        return size;
    }
    public boolean empty(){
        return size==0;
    }

    //哈希函数
    private int hashFunc(int key){
        return key%capacity;
    }

    public void PrintHashBucket(){
        for(int bucketNo = 0;bucketNo < capacity;bucketNo++){
            System.out.printf("table[%d]-->",bucketNo);
            Node cur = table[bucketNo];
            while(cur!=null){
                System.out.print("["+cur.key+","+cur.value+"]-->");
                cur = cur.next;
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        HashBucket ht = new HashBucket(5);
        ht.put(1,1);
    }
}
