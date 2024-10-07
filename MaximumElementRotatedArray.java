public class MaximumElementRotatedArray {
    public static void main(String[] args) {
        int[] nums={3,4,5,1,2};
        System.out.println(findMax(nums));
    }
    static int findMax(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[end]) {
                // Maximum element is on the right side of mid
                start = mid + 1;
            } else if (nums[mid] > nums[end]) {
                // Maximum element is on the left side of mid
                end = mid;
            } else {
                // If nums[mid] == nums[end], decrement end
                end--;
            }
        }

        // At the end of the loop, start and end will converge to the maximum element
        return nums[start];
    }
}
