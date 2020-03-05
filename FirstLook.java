package leason1;

public class FirstLook {
   /*public static void main(String[] args) throws InterruptedException {
        Thread.sleep(9999999999L);
   }*/

    /*public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(999999999L);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();//.start()方法是用来启动线程的
    }*/

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(999999999L);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();//.start()方法是用来启动线程的
        System.out.println(Thread.currentThread().getName());
    }
}