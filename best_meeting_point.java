public class Solution {
	public int minTotalDistance(int[][] grid) {
		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();
		
		for(int i = 0; i < grid.length; i++)
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					x.add(i);
					y.add(j);
				}
			}
		
		return getMP(x) + getMP(y);
	}
	
	private int getMP(List<Integer> l) {
		Collections.sort(l);
		int res = 0;
		int i = 0, j = l.size()-1;
		while(i < j)
			res += l.get(j--) - l.get(i++);
		return res;
	}
}
