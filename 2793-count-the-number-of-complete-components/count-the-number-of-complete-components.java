class Solution {

    List<Integer>[] graph;
    boolean[] visited;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                List<Integer> component = new ArrayList<>();

                dfs(i, component);

                int size = component.size();
                boolean complete = true;

                for (int node : component) {
                    if (graph[node].size() != size - 1) {
                        complete = false;
                        break;
                    }
                }

                if (complete) {
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int node, List<Integer> component) {

        visited[node] = true;
        component.add(node);

        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, component);
            }
        }
    }
}