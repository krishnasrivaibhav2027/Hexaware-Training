public class findMountainArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 5;
        int result = printIndex(arr, target);
        if (result != -1) {
            System.out.println("Element " + target + " found at index: " + result);
        } else {
            System.out.println("Element " + target + " not found in the array.");
        }
    }

    static int printIndex(int[] arr, int target) {
        int peak = findPeakElement(arr);
        int ascArray = orderAgnosticBS(arr, 0, peak, target);
        if (ascArray != -1) {
            return ascArray;
        } else {
            return orderAgnosticBS(arr, peak + 1, arr.length - 1, target);
        }
    }

    static int findPeakElement(int[] arr) {
        int start = 0, end = arr.length - 1, mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int orderAgnosticBS(int[] arr, int start, int end, int target) {
        boolean isAsc = arr[start] < arr[end];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else {
                if (isAsc) {
                    if (target < arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (target > arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
