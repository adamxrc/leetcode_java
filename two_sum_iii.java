public class TwoSum {
  Map<Integer,Integer> map = new HashMap<Integer,Integer>();
  
  public void add(int value) {
    if(map.containsKey(value)) {
      map.put(value, map.get(value)+1);
    } else {
      map.put(value, 1);
    }
  }
  
  public void find(int value) {
    for(int key : map.keySet()) {
      int another = value - key;
      if(another == key && map.get(key) > 1)
        return true;
      else if(another != key && map.containsKey(another))
        return true;
    }
    return false;
  }
}
