class Solution {
    public String smallestPalindrome(String s) {
        int[] count = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        String left = "";
        String mid = "";

        // Build left half and middle character
        for (int i = 0; i < 26; i++) {
            while (count[i] > 1) {
                left += (char) (i + 'a');
                count[i] -= 2;
            }

            if (count[i] == 1) {
                mid = String.valueOf((char) (i + 'a'));
            }
        }

        // Reverse left half
        String right = new StringBuilder(left).reverse().toString();

        return left + mid + right;
    }
}