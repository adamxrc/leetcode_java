public class Codec {
	public String encode(List<String> strs) {
		StringBuffer output = new StringBuffer();
		for(String str : strs) {
			output.append(String.valueOf(str.length()) + "#");
			output.append(str);
		}
		return output.toString();
	}
	
	public List<String> decode(String s) {
		List<String> res = new ArrayList<String>();
		int start = 0;
		while(start < s.length()) {
			int idx = s.indexOf('#', start);
			int size = Integer.parseInt(s.substring(start, idx));
			res.add(s.substring(idx + 1, idx + size + 1));
			start = idx + size + 1;
		}
		return res;
	}
}
