class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            q.offer(i);
        }

        while (!q.isEmpty()) {

            int num = q.poll();

            if (num >= low && num <= high) {
                result.add(num);
            }

            int lastDigit = num % 10;

            if (lastDigit < 9) {
                int next = num * 10 + (lastDigit + 1);  //12---->123

                if (next <= high) {
                    q.offer(next);
                }
            }
        }

        return result;
    }
}