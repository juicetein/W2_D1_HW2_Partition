public class Partition {

    // lomuto partition: pivot = arr[high]
    // returns pivot final index
    public static int lomutoPartition(int[] arr, int low, int high) {
        if (arr == null) throw new IllegalArgumentException("arr is null");
        if (arr.length == 0) return -1;
        if (low < 0 || high < 0 || low >= arr.length || high >= arr.length || low > high) {
            throw new IllegalArgumentException("Invalid low/high");
        }

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    // hoare partition: pivot = arr[low]
    // returns index p (split point)
    public static int hoarePartition(int[] arr, int low, int high) {
        if (arr == null) throw new IllegalArgumentException("arr is null");
        if (arr.length == 0) return -1;
        if (low < 0 || high < 0 || low >= arr.length || high >= arr.length || low > high) {
            throw new IllegalArgumentException("Invalid low/high");
        }

        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do { i++; } while (arr[i] < pivot);
            do { j--; } while (arr[j] > pivot);

            if (i >= j) return j;

            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
