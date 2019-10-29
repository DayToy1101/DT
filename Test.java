public class Test {
    public static void main(String[] args) {
        MyArrayList myarraylist=new MyArrayList();
        myarraylist.add(0,5);
        myarraylist.add(0,3);
        myarraylist.add(0,3);


         myarraylist.display();
        System.out.println(myarraylist.contains(3));
        System.out.println(myarraylist.search(5));
        System.out.println(myarraylist.getPos(2));
        myarraylist.setPos(3,6);
        myarraylist.display();
        myarraylist.remove(3);
        System.out.println(myarraylist.size());
        myarraylist.clear();

    }
}
