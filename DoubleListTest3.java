public class DoubleListTest {
    public static void main(String[] args) {
        DoubleList list=new DoubleList();
        list.addFirst(4);
        list.addFirst(3);
        list.addLast(6);
        list.addIndex(2,5);
        list.addIndex(0,2);
        list.addIndex(5,7);
        list.display();
        //System.out.println(list.remove(7));
        list.remove(7);
        list.remove(2);
       /* int ret=list.remove(8);
        System.out.println(ret);*/
        list.display();
        list.removeAllKey(5);
        list.display();
        list.clear();
    }
}
