public static void main(String[] args) {
        String[] str = {"1","2","+","3","*"};
        int ret = evalRPN(str);
        System.out.println(ret);
    }
    public static int evalRPN(String[]tokens){
        Stack<Integer> s = new Stack<>();
        int a,b;
        for (String i:tokens) {
            switch (i){
                case"+":
                    a=s.pop();
                    b=s.pop();
                    s.push(b+a);
                    break;
                case"-":
                    a=s.pop();
                    b=s.pop();
                    s.push(b-a);
                    break;
                case"*":
                    a=s.pop();
                    b=s.pop();
                    s.push(b*a);
                    break;
                case"/":
                    a=s.pop();
                    b=s.pop();
                    s.push(b/a);
                    break;
                default:
                    s.push(Integer.valueOf(i));
                    break;
            }
        }
        return s.pop();
    }