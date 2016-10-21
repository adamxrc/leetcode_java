/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */  
public class Solution {
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		PriorityQueue<Double> maxHeap = new PriorityQueue<Double>(k, new Comparator<Double>() {
			@Override
			public int compare(Double x, Double y) {
				return (int)(y-x);
			}
		});
		
		Set<Integer> set = new HashSet<Integer>();
		
		rec(root, target, k, maxHeap, set);
		
		return new ArrayList<Integer>(set);
	}
	
	private void rec(TreeNode root, double target, int k, PriorityQueue<Double> maxHeap, Set<Integer> set) {
		if(root == null)
			return;
		
		double diff = Math.abs(root.val - target);
		
		if(maxHeap.size() < k) {
			maxHeap.offer(diff);
			set.add(root.val);
		} else if(diff < maxHeap.peek()) {
			double x = maxHeap.poll();
			if(!set.remove(target+x))
				set.remove(target-x);
			maxHeap.offer(diff);
			set.add(root.val);
		} else {
			if(root.val > target)
				rec(root.left, target, k, maxHeap, set);
			else
				rec(root.right, target, k, maxHeap, set);
			return;
		}
		rec(root.left, target, k, maxHeap, set);
		rec(root.right, target, k, maxHeap, set);
	}
}
