public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {9,2,7,8,12,1};
        int temp, smallest;

        for(int a = 0; a < nums.length - 1; a++) {
            smallest = a;

            for (int i = a + 1; i < nums.length; i++) {
                if (nums[i] < nums[smallest]) {
                    smallest = i;
                }
            }
            temp = nums[a];
            nums[a] = nums[smallest];
            nums[smallest] = temp;
        }

        for(int num : nums) {
            System.out.print(num + " ");
        }

    }
}
