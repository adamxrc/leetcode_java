public class Solution {
	public int shortestDistance(int[][] grid) {
		int rows = grid.length;
		if(rows == 0)
			return -1;
		int cols = grid[0].length;
		
		int[][] dist = new int[m][n];
		int[][] nums = new int[m][n];
		
		int buildingNums = 0;
		
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 1) {
					buildingNums++;
					bfs(grid, i, j, dist, nums);
				}
			}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildingNums)
					min = Math.min(min, dist[i][j]);
			}
		
		if(min != Integer.MAX_VALUE)
			return min;
		return -1;
	}
	
	private void bfs(int[][] grid, int row, int col, int[][] dist, int[][] nums) {
		int rows = grid.length;
		int cols = grid[0].length;
		
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[]{row, col});
		
		int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
		boolean[][] visited = new boolean[rows][cols];
		int level = 0;
		
		while(!queue.isEmpty()) {
			level++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] coords = q.remove();
				for(int k = 0; k < dirs.length; k++) {
					int x = coords[0] + dirs[k][0];
					int y = coords[1] + dirs[k][1];
					if(x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 0) {
						visited[x][y] = true;
						dist[x][y] += level;
						nums[x][y]++;
						q.add(new int[]{x, y});
					}
				}
			}
		}
	}
}
