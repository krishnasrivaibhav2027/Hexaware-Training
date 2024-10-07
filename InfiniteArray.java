public class InfiniteArray {
    static int binarySearch(int[] arr, int start, int end, int target) {
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return -1;
    }

    static int ans(int[] arr, int target) {
        int start = 0, end = 1;
        while (end < arr.length && target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(arr, start, Math.min(end, arr.length - 1), target);
    }

    public static void main(String[] args) {
        int[] arr = { 5, 10, 15, 20, 25, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95, 100, 105, 185, 195, 225, 775 };
        int target = 775;
        System.out.println(ans(arr, target));
    }
}
