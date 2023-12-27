public class easyinversioncount {
    public static void main(String[] args) {
        int[] array = {3,2,1};
        int inversionCount = countInversions(array);
        System.out.println("The number of inversions in the array is: " + inversionCount);
    }

    public static int countInversions(int[] array) {
        int count = 0;
        int n = array.length;

        // Iterate over each element in the array
        for (int i = 0; i < n; i++) {
            // For each element, check the elements to its right
            for (int j = i + 1; j < n; j++) {
                // If the current element is greater than the next element, it's an inversion
                if (array[i] > array[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
