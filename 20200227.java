public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s) {
        if(s==null){
            return true;
        }
        s=s.toLowerCase();
        int len=s.length();
        int i=0;
        int j=len-1;
        while(j>i){
            if((s.charAt(i)>='0'&&s.charAt(i)<='9')||(s.charAt(i)>='a'&&s.charAt(i)<='z')){
                if((s.charAt(j)>='0'&&s.charAt(j)<='9')||(s.charAt(j)>='a'&&s.charAt(j)<='z')){
                    if(s.charAt(i)!=s.charAt(j)){
                        return false;
                    }else{
                        i++;
                        j--;
                    }
                }else{
                    j--;
                }
            }else{
                i++;
            }
        }
        return true;
    }