class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k = k % total;

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {

                // Current position in 1D
                int curr = i * n + j;

                // Original position before shifting
                int old = (curr - k + total) % total;

                int oldRow = old / n;
                int oldCol = old % n;

                row.add(grid[oldRow][oldCol]);
            }

            ans.add(row);
        }

        return ans;
    }
}