public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixes = new HashSet<>();
        int maxLength = 0;

        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }

        for (int num : arr2) {
            while (num > 0) {
                if (prefixes.contains(num)) {
                    int len = (int) Math.log10(num) + 1;
                    if (len > maxLength) {
                        maxLength = len;
                    }
                    break;
                }
                num /= 10;
            }
        }

        return maxLength;
    }
}

