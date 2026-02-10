import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PartitionTest {

    // arrays from the assignment screenshot
    private final int[] sorted = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
    private final int[] empty = {};
    private final int[] unsorted = {84, 3, 7, 1, 9, 6, 2, 5};

    // ----- lomuto -----

    @Test
    void lomuto_emptyArray_returnsMinus1() {
        int[] a = empty.clone();
        int p = Partition.lomutoPartition(a, 0, 0);
        assertEquals(-1, p);
    }

    @Test
    void lomuto_sorted_partitionPropertyHolds() {
        int[] a = sorted.clone();
        int low = 0, high = a.length - 1;
        int pivotValue = a[high];

        int p = Partition.lomutoPartition(a, low, high);

        assertTrue(p >= low && p <= high);
        assertEquals(pivotValue, a[p]);

        for (int i = low; i < p; i++) assertTrue(a[i] <= pivotValue);
        for (int i = p + 1; i <= high; i++) assertTrue(a[i] > pivotValue);
    }

    @Test
    void lomuto_unsorted_partitionPropertyHolds() {
        int[] a = unsorted.clone();
        int low = 0, high = a.length - 1;
        int pivotValue = a[high];

        int p = Partition.lomutoPartition(a, low, high);

        assertTrue(p >= low && p <= high);
        assertEquals(pivotValue, a[p]);

        for (int i = low; i < p; i++) assertTrue(a[i] <= pivotValue);
        for (int i = p + 1; i <= high; i++) assertTrue(a[i] > pivotValue);
    }

    // ----- hoare -----

    @Test
    void hoare_emptyArray_returnsMinus1() {
        int[] a = empty.clone();
        int p = Partition.hoarePartition(a, 0, 0);
        assertEquals(-1, p);
    }

    @Test
    void hoare_sorted_partitionPropertyHolds() {
        int[] a = sorted.clone();
        int low = 0, high = a.length - 1;
        int pivotValue = a[low];

        int p = Partition.hoarePartition(a, low, high);

        assertTrue(p >= low && p <= high);

        for (int i = low; i <= p; i++) assertTrue(a[i] <= pivotValue);
        for (int i = p + 1; i <= high; i++) assertTrue(a[i] >= pivotValue);
    }

    @Test
    void hoare_unsorted_partitionPropertyHolds() {
        int[] a = unsorted.clone();
        int low = 0, high = a.length - 1;
        int pivotValue = a[low];

        int p = Partition.hoarePartition(a, low, high);

        assertTrue(p >= low && p <= high);

        for (int i = low; i <= p; i++) assertTrue(a[i] <= pivotValue);
        for (int i = p + 1; i <= high; i++) assertTrue(a[i] >= pivotValue);
    }
}
