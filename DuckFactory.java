package model;

public class DuckFactory {
    public static Duck create(){
        Duck d = new Duck();
        d.setName("June");
        d.setAge(3);
        return d;
    }
    public Duck create2(){
        Duck d = new Duck();
        d.setName("小明");
        d.setAge(10);
        return d;
    }
}
