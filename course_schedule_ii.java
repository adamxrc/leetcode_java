public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisities) {
        List<Integer> res = new ArrayList<Integer>();
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<Integer>());
            inDegree.put(i, 0);
        }
        for(int i = 0; i < prerequisities.length; i++) {
            int[] pair = prerequisities[i];
            graph.get(pair[1]).add(pair[0]);
            inDegree.put(pair[0], inDegree.get(pair[0])+1);
        }
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree.get(i).intValue() == 0)
                que.offer(i);
        }
        while(!que.isEmpty()) {
            int u = que.poll();
            res.add(u);
            List<Integer> list = graph.get(u);
            for(Integer e: list) {
                inDegree.put(e, inDegree.get(e)-1);
                if(inDegree.get(c).intValue() == 0)
                    que.offer(e);
            }
        }
        if(res.size() != numCourses)
            return new int[0];
        int[] orders = new int[res.size()];
        for(int i = 0; i < orders.length; i++)
            orders[i] = res.get(i).intValue();
        return orders;
    }
}
