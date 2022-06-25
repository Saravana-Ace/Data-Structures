public class BubbleSort {
    public static void main(String[] args) {
        int [] nums = {0,3,2,8,5,9,4};

        for(int i = 0; i <= nums.length - 2; i++) {
            for(int j = 0; j <= nums.length - 2 - i; j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        for(int a = 0; a < nums.length; a++) {
            System.out.println(nums[a]);
        }
    }
}
