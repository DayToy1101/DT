public class TestDemo7 {
    public static void main(String[] args) {
        SingleList7 list=new SingleList7();
        list.addFirst(7);
        list.addFirst(6);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(3);
        list.addFirst(2);
        list.display1();
        System.out.println("==============================");
        list.display(list.partition(4));
        System.out.println("==============================");
        list.deleteDuplication();
        list.display1();
        System.out.println("==============================");
        System.out.println(list.chkPalindrome());
        System.out.println("==============================");
        //list.createLoop();
        //list.hasCycle();
        //System.out.println(list.listLength());
    }
}
