public static boolean chkParenthesis(String A, int n) {
        Stack<String> s = new Stack<>();
        //char[] a = A.toCharArray();
        for(int i = 0;i<A.length();i++){
            if(A.charAt(i)=='('){
                s.push(String.valueOf(A.charAt(i)));
            }else if(A.charAt(i)==')'){
                s.pop();
            }else{
                return false;
            }
        }
        if(s.empty()){
            return true;
        }
        return false;

    }