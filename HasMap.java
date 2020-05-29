import java.util.*;

public class HasMap {
    public static void testTreeMap(){
        Map<String,String> m1 = new TreeMap<>();
        m1.put("apple","苹果");
        m1.put("orange","橘子");
        m1.put("peach","桃");
        System.out.println(m1.size());
        System.out.println(m1);

        //验证key是否可以重复--->如果key不存在，将该key-value组成的键值对直接插入
        //如果key存在，使用value替换原key所对应的value
        //在插入key-value期间，Map会保证key是一个有序的序列----延伸：插入期间肯定要对key进行比较--->如果key是自定义类型的元素，该类的对象必须要能够比较大小--->实现comparable接口compareTo
        m1.put("orange","橙子");
        System.out.println(m1.size());
        System.out.println(m1);
        //key一定不能为空；如果为空,会抛出异常；key为空就不能进行比较
        //value可以为空
        m1.put("banana","null");
        //put方法的返回值：如果key存在

        //get()如果key存在，返回与key对应的value
        //如果key不存在，返回null
        //如果key是null，抛出空指针异常
        System.out.println(m1.get("apple"));
        System.out.println(m1.get("watermelon"));
        //remove（）：
        //如果key存在，删除该键值对，然后返回该键值对中的value
        //如果key不存在，直接返回null

        //打印所有的key
        for (String s:m1.keySet()) {
            System.out.print(s+" ");
        }
        System.out.println();
        //打印所有的value
        for (String s:m1.values()) {
            System.out.print(s+" ");
        }
        System.out.println();
        //打印所有的键值对
        for(Map.Entry<String,String> e:m1.entrySet()){
            System.out.print(e.getKey()+"-->"+e.getValue());
        }
        System.out.println();

    }
    public static void testHashMap(){
        Map<String,String> m1 = new HashMap<>();
        m1.put("apple","苹果");
        m1.put("orange","橘子");
        m1.put("peach","桃");
        System.out.println(m1.size());
        System.out.println(m1);

        //验证key是否可以重复--->如果key不存在，将该key-value组成的键值对直接插入
        //如果key存在，使用value替换原key所对应的value
        //在插入key-value期间，Map会保证key是一个有序的序列----延伸：插入期间肯定要对key进行比较--->如果key是自定义类型的元素，该类的对象必须要能够比较大小--->实现comparable接口compareTo
        m1.put("orange","橙子");
        System.out.println(m1.size());
        System.out.println(m1);
        //key一定不能为空；如果为空,会抛出异常；key为空就不能进行比较
        //value可以为空
        m1.put("banana","null");
        //put方法的返回值：如果key存在

        //get()如果key存在，返回与key对应的value
        //如果key不存在，返回null
        //如果key是null，抛出空指针异常
        System.out.println(m1.get("apple"));
        System.out.println(m1.get("watermelon"));
        //remove（）：
        //如果key存在，删除该键值对，然后返回该键值对中的value
        //如果key不存在，直接返回null

        //打印所有的key
        for (String s:m1.keySet()) {
            System.out.print(s+" ");
        }
        System.out.println();
        //打印所有的value
        for (String s:m1.values()) {
            System.out.print(s+" ");
        }
        System.out.println();
        //打印所有的键值对
        for(Map.Entry<String,String> e:m1.entrySet()){
            System.out.print(e.getKey()+"-->"+e.getValue());
        }
        System.out.println();
    }
    public static void testTreeSet(){
        Set<String> s = new TreeSet<>();
        System.out.println(s.add("orange"));
        System.out.println(s.add("peach"));
        System.out.println(s.add("apple"));
        System.out.println(s.size());
        System.out.println(s);

        System.out.println(s.add("apple"));
        System.out.println(s);

        if(s.contains("watermelon")){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        //遍历
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(s.remove("watermelon"));
        System.out.println(s.remove("apple"));
        s.clear();
    }
    public static void testHashSet(){
        Set<String> s = new HashSet<>();
        System.out.println(s.add("orange"));
        System.out.println(s.add("peach"));
        System.out.println(s.add("apple"));
        System.out.println(s.size());
        System.out.println(s);

        System.out.println(s.add("apple"));
        System.out.println(s);

        if(s.contains("watermelon")){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

        //遍历
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(s.remove("watermelon"));
        System.out.println(s.remove("apple"));
        s.clear();
    }

    public static void main(String[] args) {
        //testTreeMap();
        //testHashMap();
        //testTreeSet();
        //testHashSet();
    }
}

