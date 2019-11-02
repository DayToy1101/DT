public class SingleTest {
    public static void main(String[] args) {
        SingleList list = new SingleList();
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.display();
        System.out.println("-------------------------");
        list.addLast(6);
        list.display();
        System.out.println("-------------------------");
        list.addIndex(3, 9);
        list.display();
        System.out.println("-------------------------");
        list.addIndex(7, 9);
        list.display();
        System.out.println("-------------------------");
        System.out.println(list.contains(5));
        System.out.println("-------------------------");
        list.remove(9);
        list.display();
        System.out.println("-------------------------");
        list.removeAllKey(9);
        list.display();
        System.out.println("-------------------------");
        list.display2(list.reverseList());
        System.out.println("-------------------------");
        System.out.println(list.middleNode());
        System.out.println("-------------------------");
        System.out.println(list.findKthToTail(1) );
    }
}
