public class Solution {
	int l,r,u,d;  
      
    public int minArea(char[][] image, int x, int y) {  
        //input check  
        u=x;  
        d=x;  
        l=y;  
        r=y;  
        int m = image.length-1;  
        int n = image[0].length-1;  
          
        boolean[][] visited = new boolean[m+1][n+1];  
          
        search(image, visited, x, y, m, n);  
          
        return (r-l+1) * (d-u+1);  
    }  
      
    private void search(char[][] image, boolean[][] visited, int x, int y, int m, int n) {  
        if(x<0 || x>m || y<0 || y>n || image[x][y]!='1' || visited[x][y]) return;  
        visited[x][y] = true;  
          
        if(x<u) u=x;  
        else if(x>d)d=x;  
        if(y<l) l=y;  
        else if(y>r) r=y;  
          
        search(image, visited, x-1, y, m, n);  
        search(image, visited, x, y-1, m, n);  
        search(image, visited, x+1, y, m, n);  
        search(image, visited, x, y+1, m, n);  
    }  
}
