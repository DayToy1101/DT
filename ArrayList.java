import java.util.Arrays;

class ArrayList{
    private final int CAPACITY=10;
    private int[] elem;
    private int usedSize;
    public ArrayList(){
        this.elem=new int[CAPACITY];
        this.usedSize=0;
    }
    public boolean isFull(){
        if(this.usedSize==this.elem.length){
            return true;
        }
        return false;
    }
    //在pos位置插入元素
    public void add(int pos,int data){
        if(isFull()){
            this.elem=Arrays.copyOf(this.elem,this.elem.length*2);
        }
        if(pos<0||pos>this.usedSize){
            System.out.println("输入位置不合法！");
        }else if(pos>=0&&pos<=this.usedSize){
            for(int i=usedSize-1;i>=pos;i--){
                this.elem[i+1]=this.elem[i];
            }
            this.elem[pos]=data;
            this.usedSize++;
        }
    }
    //判断是否包含某个元素
    public boolean contains(int toFind){
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    //查找某个元素对应的位置
    public int search(int toFind){
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toFind){
                return i+1;
            }
        }
        return -1;
    }
    //获取 pos 位置的元素
    public int getPos(int pos){
        if(pos>=0&&pos<=this.usedSize){
            return this.elem[pos];
        }
        return -1;
    }
    // 给 pos 位置的元素设为 value
    public void setPos(int pos, int value){
       this.elem[pos-1]=value;
    }
    //删除第一次出现的关键字key
    public void remove(int toRemove){
        for(int i=0;i<this.usedSize;i++){
            if(this.elem[i]==toRemove){
                for(int j=i;j<=usedSize;j++){
                    this.elem[j]=this.elem[j+1];
                }
                this.usedSize++;
            }
        }
    }
    // 获取顺序表长度
    public int size(){
        return this.usedSize;
    }
    //打印顺序表
    public void display(){
        for(int i=0;i<this.usedSize;i++){
            System.out.print(this.elem[i]+" ");
        }
        System.out.println("\n");
    }
    // 清空顺序表
    public void clear(){
        this.usedSize=0;
    }

}