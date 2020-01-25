public class ArrayTest {
        public static void main(String[] args) {
            ArrayList list=new ArrayList();
            list.add(0,5);
            list.add(0,3);
            list.add(0,3);


            list.display();
            System.out.println(list.contains(3));
            System.out.println(list.search(5));
            System.out.println(list.getPos(2));
            list.setPos(3,6);
            list.display();
            list.remove(3);
            System.out.println(list.size());
            list.clear();

        }
    }

