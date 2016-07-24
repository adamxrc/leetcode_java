public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return result;
        int beginX = 0, endX = matrix[0].length-1;
        int beginY = 0, endY = matrix.length-1;
        while(true) {
            for(int i = beginX; i <= endX; i++)
                result.add(matrix[beginY][i]);
            if(++beginY > endY)
                break;
            
            for(int i = beginY; i <= endY; i++)
                result.add(matrix[i][endX]);
            if(beginX > --endX)
                break;
                
            for(int i = endX; i >= beginX; i--)
                result.add(matrix[endY][i]);
            if(beginY > --endY)
                break;
                
            for(int i = endY; i >= beginY; i--)
                result.add(matrix[i][beginX]);
            if(++beginX > endX)
                break;
        }
        return result;
    }
}
