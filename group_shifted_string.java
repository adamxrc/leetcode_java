public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str: strings) {
            String key = "";
            for(int i = 1; i < str.length(); i++) {
                int offset = str.charAt(i) - str.charAt(i-1);
                key += offset < 0 ? offset+26: offset;
            }
            if(!map.containsKey(key))
                map.put(key, new ArrayList<String>());
            map.get(key).add(str);
        }
        for(List<String> list: map.values())
            result.add(list);
        return result;
    }
}
