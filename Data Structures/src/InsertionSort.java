public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {9,2,7,8,12,1, 10, 3, 7, 5, 54, 3, 2, 3, 8,7,5,4,3,6,9,0,1,3,5,6,8,9,6,5,4,31,34,5,68,314,7,1,2,3,4,5,67,8,5345,45,345,434,4,44,4};
        int i, j, current;

        for(i = 0; i < nums.length; i++) {
            current = nums[i];
            j = i - 1;
            while(j >= 0 && nums[j] > current) {
                nums[j+1] = nums[j];
                j -= 1;
            }
            nums[j+1] = current;
        }

        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}
