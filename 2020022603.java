public static void main(String[] args) {
        int[] arr={2, 1};
        System.out.println(findUnsortedSubarray(arr));
    }
    public static int findUnsortedSubarray(int[] nums){
        int len = nums.length;
        int max=nums[0];
        int min=nums[len-1];
        int start=-1;
        int end=0;
        for(int i=1;i<nums.length;i++){
            if(max>nums[i]){
                start = i;
            }else{
                max = nums[i];
            }
            if(min<nums[len-i-1]){
                end = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return start-end+1; 
    }