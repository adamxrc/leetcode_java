public class Solution {
	public void wallsAndGates(int[][] rooms) {
		if(rooms == null || rooms.length == 0 || rooms[0] == null || 
		   rooms[0].length == 0)
			return;
		int m = rooms.length;
		int n = rooms[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i = 0; i < m; i++)
			for(int j = 0; j < n; j++) {
				if(rooms[i][j] == Integer.MAX_VALUE)
					roomms[i][j] = search(rooms, i, j, m, n, visited);
			}
	}
	
	private int search(int[][] rooms, int i, int j, int m, int n, boolean[][] visited) {
		if(i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] == -1)
			return Integer.MAX_VALUE;
		if(rooms[i][j] == 0)
			return 0;
		if(visited[i][j])
			return rooms[i][j];
		if(rooms[i][j] > 0 && rooms[i][j] < Integer.MAX_VALUE)
			return rooms[i][j];
		
		visited[i][j] = true;
		
		int up = search(rooms, i, j-1, m, n, visited);
		int down = search(rooms, i, j+1, m, n, visited);
		int left = search(rooms, i-1, j, m, n, visited);
		int right = search(rooms, i+1, j, m, n, visited);
		
		visited[i][j] = false;
		
		int min = Math.min(Math.min(up, down), Math.min(left, right));
		return min == Integer.MAX_VALUE ? min : min+1;
	}
}
