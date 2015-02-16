public class Solution { 
  public List<String> findMissingRanges(int[] A, int lower, int upper) {
    List<String> list = new ArrayList<String>();
    if(A.length == 0) {
      if(upper - lower > 1) 
        list.add(lower+"->"+upper);
      else
        list.add(lower+"");
      return list;
    }
    if(lower < A[0]) {
      if(A[0]-lower >= 2)
        list.add(lower+"->"+(A[0]-1));
      else if(A[0]-lower == 1)
        list.add(lower+"");
    }
    for(int i = 1; i < A.length; i++) {
      if(A[i]-A[i-1] == 2)
        list.add((A[i-1]+1)+"");
      else if(A[i]-A[i-1] > 2)
        list.add((A[i-1]+1)+"->"+(A[i]-1));
    }
    if(upper > A[A.length-1]) {
      if(upper-A[A.length-1] == 1)
        list.add(upper+"");
      else if(upper-A[A.length-1] >= 2)
        list.add((A[A.length-1]+1)+"->"+upper);
    }
    return list;
  }
}
