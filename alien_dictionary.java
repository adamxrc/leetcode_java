public class Solution {
	public String alienOrder(String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
		Map<Character, Integer> indegree = new HashMap<Character, Integer>();
		StringBuilder order = new StringBuilder();
		
		initialize(words, graph, indegree);
		buildGraphAndGetIndegree(words, graph, indegree);
		topologicalSort(order, graph, indegree);
		
		return order.length() == indegree.size() ? order : "";
	}
	
	private void initialize(String[] words, Map<Character, Set<Character>> graph, 
							Map<Character, Integer> indegree) {
		for(String word : words) {
			for(int i = 0; i < word.length(); i++) {
				char curr = word.charAt(i);
				if(graph.get(curr) == null)
					graph.put(curr, new HashSet<Character>());
				if(indegree.get(curr) == null)
					indegree.put(curr, 0);
			}
		}
	}
	
	private void buildGraphAndGetIndegree(String[] words, Map<Character, Set<Character>> graph,
										  Map<Character, Integer> indegree) {
		Set<String> edges = new HashSet<String>();
		for(int i = 0; i < words.length-1; i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			for(int j = 0; j < word1.length() && j < word2.length(); j++) {
				char from = word1.charAt(j);
				char to = word2.charAt(j);
				if(from == to)
					continue;
				if(!edges.contains(from+""+to)) {
					Set<Character> set = graph.get(from);
					set.add(to);
					graph.put(from, set);
					Integer toin = indegree.get(to);
					toin++;
					indegree.put(to, toin);
					edges.add(from+""+to);
					break;
				}
			}
		}
	}
	
	private void topologicalSort(StringBuilder order, Map<Character, Set<Character>> graph,
								 Map<Character, Integer> indegree) {
		Queue<Character> queue = new LinkedList<Character>();
		for(Character key : indegree.keySet()) {
			if(indegree.get(key) == 0)
				queue.offer(key);
		}
		while(!queue.isEmpty()) {
			Character curr = queue.poll();
			order.append(curr);
			Set<Character> set = graph.get(curr);
			if(set != null) {
				for(Character c : set) {
					Integer val = indegree.get(c);
					val--;
					if(val == 0)
						queue.offer(c);
					indegree.put(c, val);
				}
			}
		}
	}
}
