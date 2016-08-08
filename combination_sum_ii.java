public class Solution {
    private List<List<Integer>> results;
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates.length < 1)
            return results;
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        results = new ArrayList<List<Integer>>();
        helper(path, candidates, target, 0);
        return results;
    }
    
    private void helper(List<Integer> path, int[] candidates, int sum, int pos) {
        if(sum == 0) {
            results.add(new ArrayList<Integer>(path));
            return;
        }
        
        if(pos >= candidates.length || sum < 0)
            return;
        
        int prev = -1;
        for(int i = pos; i < candidates.length; i++) {
            if(prev != candidates[i]) {
                path.add(candidates[i]);
                helper(path, candidates, sum-candidates[i], i+1);
                path.remove(path.size()-1);
                prev = candidates[i];
            }
        }
    }
}
