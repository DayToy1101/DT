public class TestDemo6 {
    public static void main(String[] args) {
        MySingleList6 list=new MySingleList6();
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(3);
        list.addLast(5);
        list.addLast(6);
        list.addLast(3);
        list.display1();
        System.out.println("===================");
        System.out.println(list.middleList().data);
        System.out.println("===================");
        list.remove(3);
        list.display1();
        System.out.println("===================");
        list.removeAllkey(3);
        list.display1();
        System.out.println("===================");
        list.addIndex(0,2);
        list.addIndex(1,3);
        list.addIndex(5,7);
        list.display1();
        System.out.println("====================");
        System.out.println(list.findKthToTail(4).data);
        System.out.println("====================");
        System.out.println(list.contains(6));
        System.out.println("====================");
        list.display(list.reseverList());
    }
}
