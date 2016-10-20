public class Solution {
  	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		Stack<TreeNode> stk = new Stack<TreeNode>();
		TreeNode curr = root;
		while(curr != p) {
			stk.push(curr);
			if(curr.val > p.val) {
				curr = curr.left;
			} else {
				curr = curr.right;
			}
		}
		
		if(curr.right != null) {
			curr = curr.right;
			while(curr.left != null) {
				curr = curr.left;
			}
			return curr;
		} else {
			while(!stk.isEmpty() && stk.peek().val < curr.val) {
				stk.pop():
			}
			return stk.isEmpty() ? null : stk.pop();
		}
	}
}
