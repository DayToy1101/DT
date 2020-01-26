public class TestDemo9 {
    public static void main(String[] args) {
        DoubleList2 list=new DoubleList2();
        list.addFirst(7);
        list.addFirst(6);
        list.addLast(8);
        list.addFirst(5);
        list.addFirst(4);
        list.display();
        list.addIndex(0,3);
        list.display();
        list.remove(8);
        list.display();
        list.addIndex(5,6);
        list.addIndex(4,6);
        list.display();
        list.removeAllKey(6);
        list.display();
    }
}
