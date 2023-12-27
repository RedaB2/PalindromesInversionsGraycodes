import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    /**
     * Main method to generate the Gray code, Klutzomaniac actions, and Klutzomaniacs riding sequences.
     *
     * @param args Command line arguments (We don't use them.)
     */
    public static void main(String[] args) {
        // Set the Gray code order
        int n = 5;

        // Generate Gray code
        List<String> grayCode = generateGrayCode(n);

        // Generate Klutzomaniac actions based on Gray code
        List<String> klutzomaniacActions = generateKlutzomaniacActions(grayCode);

        // Generate Klutzomaniacs riding sequence based on Gray code
        List<String> klutzomaniacsRiding = generateKlutzomaniacsRiding(grayCode);

        // Print the table
        System.out.println("Index | Gray Code | Klutzomaniacs Riding | Klutzomaniac Action");
        int index = 0;
        for (int i = 0; i < grayCode.size(); i++) {
            System.out.println(index + " | " + grayCode.get(i) + " | " + klutzomaniacsRiding.get(i) + " | " + klutzomaniacActions.get(i));
            index++;
        }
    }

    /**
     * Generates the Binary Reflected Gray Code of order n using a recursive algorithm.
     *
     * @param n The order of the Gray code.
     * @return A list of strings containing the Gray code of order n.
     */
    private static List<String> generateGrayCode(int n) {
        if (n == 1) {
            List<String> baseGrayCode = new ArrayList<>();
            baseGrayCode.add("0");
            baseGrayCode.add("1");
            return baseGrayCode;
        }

        List<String> prevGrayCode = generateGrayCode(n - 1);
        int codeSize = prevGrayCode.size();
        List<String> currentGrayCode = new ArrayList<>(codeSize * 2);

        for (int i = 0; i < codeSize; i++) {
            currentGrayCode.add("0" + prevGrayCode.get(i));
        }

        for (int i = codeSize - 1; i >= 0; i--) {
            currentGrayCode.add("1" + prevGrayCode.get(i));
        }

        return currentGrayCode;
    }

    /**
     * Generates a list of Klutzomaniac actions based on the Gray code sequence.
     *
     * @param grayCode A list of strings containing the Gray code.
     * @return A list of strings representing Klutzomaniac actions.
     */
    private static List<String> generateKlutzomaniacActions(List<String> grayCode) {
        List<String> actions = new ArrayList<>();
        String[] klutzomaniacs = {"Empty Tricycle", "Axel", "Boxo", "Crunchy", "Doofus", "Enzo"};

        for (int i = 1; i < grayCode.size(); i++) {
            String prevCode = grayCode.get(i - 1);
            String currentCode = grayCode.get(i);

            int differingBitIndex = findDifferingBitIndex(prevCode, currentCode);

            if (differingBitIndex != -1) {
                if (prevCode.charAt(prevCode.length() - differingBitIndex - 1) == '0') {
                    actions.add(klutzomaniacs[differingBitIndex] + " Joins");
                } else {
                    actions.add(klutzomaniacs[differingBitIndex] + " Leaves");
                }
            } else {
                actions.add("Unknown Action");
            }
        }
        actions.add(0, "Spotlight");
        actions.add(grayCode.size() - 1, klutzomaniacs[klutzomaniacs.length - 1] + " Crashes");

        return actions;
    }

    /**
     * Generates a list of Klutzomaniacs riding sequences based on the Gray code.
     *
     * @param grayCode A list of strings containing the Gray code.
     * @return A list of strings representing the Klutzomaniacs riding sequences.
     */
    private static List<String> generateKlutzomaniacsRiding(List<String> grayCode) {
        List<String> klutzomaniacsRiding = new ArrayList<>();
        String[] klutzomaniacs = {"Axel", "Boxo", "Crunchy", "Doofus", "Enzo"};

        for (String code : grayCode) {
            StringBuilder riding = new StringBuilder();
            for (int i = 0; i < code.length(); i++) {
                if (code.charAt(i) == '1') {
                    if (riding.length() > 0) {
                        riding.append(" & ");
                    }
                    riding.append(klutzomaniacs[code.length() - 1 - i]);
                }
            }

            if (riding.length() == 0) {
                klutzomaniacsRiding.add("Empty Tricycle");
            } else {
                klutzomaniacsRiding.add(riding.toString());
            }
        }

        return klutzomaniacsRiding;
    }

    /**
     * Finds the index of the differing bit between two Gray code strings.
     *
     * @param prevCode    The previous Gray code string.
     * @param currentCode The current Gray code string.
     * @return The index of the differing bit, or -1 if no differing bit is found.
     */
    private static int findDifferingBitIndex(String prevCode, String currentCode) {
        for (int i = 0; i < prevCode.length(); i++) {
            if (prevCode.charAt(i) != currentCode.charAt(i)) {
                return prevCode.length() - i - 1;
            }
        }
        return -1;
    }
}


