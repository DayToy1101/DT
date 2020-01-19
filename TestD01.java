public class TestDemo {
    public static void main(String[] args) {
        Gran gran=new Gran();
        gran.num=10;
        gran.x=15;
        int max=Gran.max(gran.num,gran.x);
        System.out.println(max);
    }
    public static class Gran{
            int num;
        int x;
        public static int max(int num, int x){
            if(num>=x){
                return num;
            }else {
            }
                return x;
            }
        }
    }

