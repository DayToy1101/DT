 public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //while(sc.hasNextInt()){
            int n = sc.nextInt();
            if(n!=0){
                int ret = maxSum(n);
                System.out.println(ret);
            }
        //}
    }
    public static int maxSum(int n){
        int count = 0;
        int x = 0;
        while(n>=2){
            count += n/3;
            x = n/3;
            n=n-(3*x)+x;
            if(n==2){
                count++;
            }
        }
        return count;
    }