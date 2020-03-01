public class Delete {
    public static void main(String[] args) {
		int[] arr={0,1,2,2,3,0,4,2};
        int length = removeElement(arr,2);
        for(int i=0;i<length;i++){
            System.out.println(arr[i]);
		}
	}
	public static int removeElement(int[] nums, int val) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]==val){
                int j;
                for(j=i;j<length-1;j++) {
                    nums[j] = nums[j + 1];
                }
                i--;
                --length;
            }
        }
        return length;
    }
}