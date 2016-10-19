public class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n <= 0 || edges == null)
            return 0;
        
        if(n == 1 && edges.length == 0)
            return 1;
        
        int result = 0;
        boolean[] visited = new boolean[n];
        List[] adjList = new List[n];
        
        for(int i = 0; i < n; i++)
            adjList[i] = new ArrayList<>();
        
        for(int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            adjList[from].add(to);
            adjList[to].add(from);
        }
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                result++;
                countHelper(i, adjList, visited);
            }
        }
        
        return result;
    }
    
    private void countHelper(int node, List[] adjList, boolean[] visited) {
        if(visited[node])
            return;
        
        visited[node] = true;
        
        List<Integer> neighbors = adjList[node];
        
        for(int neighbor: neighbors) {
            countHelper(neighbor, adjList, visited);
        }
    }
}
