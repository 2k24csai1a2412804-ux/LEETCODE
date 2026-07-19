class Solution {
    public String smallestSubsequence(String s) {

        int[] freq = new int[126];
        boolean[] visited = new boolean[126];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch]++;
        }

        ArrayList<Character> st = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (visited[ch]) {
                freq[ch]--;
                continue;
            }

            while (!st.isEmpty()) {

                char top = st.get(st.size() - 1);

                if (top > ch && freq[top] > 0) {
                    st.remove(st.size() - 1);
                    visited[top] = false;
                } else {
                    break;
                }
            }

            st.add(ch);
            visited[ch] = true;
            freq[ch]--;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < st.size(); i++) {
            sb.append(st.get(i));
        }

        return sb.toString();
    }
}