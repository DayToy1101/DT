public class Test2 {
    public static void main(String[] args) {
        MySingleList list=new MySingleList();
        list.addFirst(5);
        list.addFirst(4);
        list.addLast(6);
      /*  System.out.println(list.size());
        list.display();
        list.addIndex(1,45);
        list.display();
        list.remove(45);
        list.display();
        list.removeAllKey(6);*/
        list.reverseList();
        list.display();
    }

}
