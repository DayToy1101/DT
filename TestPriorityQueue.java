import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Card implements Comparable<Card>{
    public int rank; // 数值
    public String suit; // 花色
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        //牌面值比较
        return rank - o.rank;

    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null||!(obj instanceof Card)){
            return false;
        }
        Card c = (Card) obj;
        return rank==c.rank && suit.equals(c.suit);
    }
}

public class TestPriorityQueue {
    public static void TestPriorityQueue1() {
        //1、构造一个空的优先级队列,底层默认长度为11
        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        //2、按照指定的容量进行构造
        //如果知道优先级队列中大概要放多少个元素，最好使用该方式进行构造
        //因为插入元素时需要不断扩容，影响程序效率
        PriorityQueue<Integer> p2 = new PriorityQueue<>(100);
        //3、可以用一个集合来直接构造优先级队列，将来就会将集合中的元素放入优先级队列
        List<Integer> L = new ArrayList<>();
        L.add(0);
        L.add(1);
        L.add(2);
        L.add(3);
        L.add(4);
        //使用List构造优先级队列时，优先级队列并不是直接将List的元素放进来
        //而是利用某种机制规则，将List中的元素进行排序
        PriorityQueue<Integer> p3 = new PriorityQueue<>(L);
        System.out.println(p3.size());
    }

    public static void TestPriorityQueue2(){
        PriorityQueue<Integer> p = new PriorityQueue<>();
        //插入的元素一定能够比大小，而且不能插入null对象
        //插入时会自动进行扩容
        //插入的时间复杂度为O（logN）
        //插入失败时，会返回false或抛出异常
        //插入元素期间，优先级队列中的元素会进行调整，首元素一定是最小的
        p.offer(4);
        p.offer(2);
        p.offer(3);
        p.offer(0);
        p.offer(5);
        p.offer(2);
        //peek()：取得是优先级队列中优先级最高的元素（第一个元素）
        System.out.println(p.peek());
        //poll()：删除优先级队列中第一个元素（最小的）
        //剩余元素会自动进行调整--》将剩余元素中最小的元素移到首元素位置
        //时间复杂度O（logN）
        p.poll();//删除一个元素
        System.out.println(p.peek());

        p.clear();
        if(p.isEmpty()){
            System.out.println("优先级队列为空");
        }else{
            System.out.println("优先级队列不为空");
        }
    }

    public static void TestPriorityQueue3(){
        PriorityQueue<Card> q = new PriorityQueue<Card>();
        q.offer(new Card(5,"♠"));
        q.offer(new Card(6,"♠"));
        q.offer(new Card(4,"♠"));
        q.offer(new Card(7,"♠"));
    }
    public static void main(String[] args) {
        TestPriorityQueue1();
        TestPriorityQueue2();

        TestPriorityQueue3();
    }
}
