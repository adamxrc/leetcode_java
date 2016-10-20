public class Solution {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<Integer> level = new LinkedList<Integer>();
		int minLevel = 0, maxLevel = 0;
		queue.offer(root);
		level.offer(0);
		
		while(!queue.isEmpty()) {
			TreeNode p = queue.poll();
			int l = level.poll();
			
			minLevel = Math.min(minLevel, l);
			maxLevel = Math.max(maxLevel, l);
			
			if(map.containsKey(l))
				map.get(l).add(p.val);
			else {
				List<Integer> list = new ArrayList<>();
				list.add(p.val);
				map.put(l, list);
			}
			
			if(p.left != null) {
				queue.offer(p.left);
				level.offer(l-1);
			}
			
			if(p.right != null) {
				queue.offer(p.right);
				level.offer(l+1);
			}
		}
		
		for(int i = minLevel; i <= maxLevel; i++) {
			if(map.containsKey(i))
				result.add(map.get(i));
		}
		
		return result;
	}
}
