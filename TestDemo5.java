public class TestDemo5 {
    public static void main(String[] args) {
        MySingleList1 list=new MySingleList1();
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(5);
        list.addFirst(6);
        list.addFirst(7);
        list.display();
        list.addIndex(2,4);
        list.display();
        System.out.println(list.findKthToTail(4).data);
        System.out.println(list.middleList().data);
        list.display( list.reverseList());
    }
}
