/** 
 * Definition for a binary tree node. 
 * public class TreeNode { 
 *     int val; 
 *     TreeNode left; 
 *     TreeNode right; 
 *     TreeNode(int x) { val = x; } 
 * } 
 */
class Range {
	boolean bst;
	int min;
	int max;
	int count = 1;
	
	public Range(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

public class Solution {
	private int max = 0;
	
	public int largestBSTSubtree(TreeNode root) {
		if(root != null)
			check(root);
		return max;
	}
	
	private Range check(TreeNode root) {
		Range range = new Range(root.val, root.val);
		Range left = root.left == null ? null : check(root.left);
		Range right = root.right == null ? null : check(root.right);
		
		if(left != null) {
			if(!left.bst || left.max >= root.val)
				return range;
			range.min = left.min;
			range.count += left.count;
		}
		
		if(right != null) {
			if(!right.bst || right.min <= root.val)
				return range;
			range.max = right.max;
			range.count += right.count;
		}
		
		range.bst = true;
		max = Math.max(max, range.count);
		
		return range;
	}
}
