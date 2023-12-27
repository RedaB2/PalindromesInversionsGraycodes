// MERGE AND SORT APPROACH
// DIVIDE AND CONQUER ALGORITHM


public class fastinversioncount {
    public static void main(String[] args) {
        int[] array = {3, 2, 1};
        int inversionCount = countInversions(array, 0, array.length - 1);
        System.out.println("The number of inversions in the array is: " + inversionCount);
    }

    public static int countInversions(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = 0;

        // Count inversions in left and right halves
        count += countInversions(array, start, mid);
        count += countInversions(array, mid + 1, end);

        // Count inversions while merging the halves
        count += mergeAndCountInversions(array, start, mid, end);

        return count;
    }

    public static int mergeAndCountInversions(int[] array, int start, int mid, int end) {
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        // Copy elements to temporary arrays
        System.arraycopy(array, start, left, 0, left.length);
        System.arraycopy(array, mid + 1, right, 0, right.length);

        int i = 0, j = 0, k = start;
        int count = 0;

        // Merge the two halves while counting inversions
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
                count += (mid + 1) - (start + i); // Add inversions
            }
        }

        // Copy remaining elements from the left half
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements from the right half
        while (j < right.length) {
            array[k++] = right[j++];
        }

        return count;
    }
}

