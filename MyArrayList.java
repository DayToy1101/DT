import java.util.Arrays;

class MyArrayList {
    public int usedSize;
    public int[] elem;

    public final int CAPACITY = 10;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }
//    判断数组是否满置
    private Boolean isFull() {
        if(usedSize==elem.length) {
            return true;
        }
        return false;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、pos是否合法
        //2、挪数据
        //3、插入数据
        //4、usedSize++
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem, this.elem.length * 2);
        }
        if(pos>=0&&pos<=this.usedSize) {
            for(int i=usedSize-1;i>=pos;i--){
                this.elem[i+1]=this.elem[i];
            }
          /*  for (int i = 0; i < pos; i++) {
                this.elem[usedSize - i] = this.elem[usedSize - i - 1];
            }*/
            this.elem[pos] = data;
            this.usedSize++;
        }
        else if(pos>this.elem.length){
            System.out.println("位置不合法!");
        }
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i+1;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
       if(pos<0||pos>this.elem.length-1){
           return -1;
       }
       return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value) {
        this.elem[pos-1]=value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        //1、顺序表是否为空
        //2、
        if(usedSize!=0){
            for(int i=0;i<usedSize-1;i++){
                if(this.elem[i]==toRemove){
                    for(int j=i;j<this.usedSize;j++){
                        this.elem[j]=this.elem[j+1];
                    }
                    usedSize--;
                }
            }
        }
        this.display();
    }
    // 获取顺序表长度
    public int size() {
       /* int count=0;
        for(int i=0;i<usedSize;i++){
            if(this.elem[i]!=0){
                count++;
            }
        }*/
        return this.usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
    // 打印顺序表
    public void display() {
        for(int i=0;i<this.usedSize;i++) {
            System.out.println(this.elem[i]+" ");
        }
        System.out.println("\n");
    }
}

