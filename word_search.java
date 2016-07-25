public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++) {
                if(existDfs(board, word, i, j, visited)
                    return true;
            }
        return false;
    }
    
    private boolean existDfs(char[][] board, String word, int i, j, boolean[][] visited) {
        if(word.length() == 0 || word.length() == 1 && word.charAt(0) == board[i][j])
            return true;
        if(word.charAt(0) != board[i][j])
            return false;
        visited[i][j] = true;
        String subword = word.substring(1);
        if(i+1<board.length && !visited[i+1][j])
            if(existDfs(board, subword, i+1, j, visited))
                return true;
        if(i-1>=0 && !visited[i-1][j])
            if(existDfs(board, subword, i-1, j, visited))
                return true;
        if(j+1<board[0].length && !visited[i][j+1])
            if(existDfs(board, subword, i, j+1, visited))
                return true;
        if(j-1>=0 && !visited[i][j-1])
            if(existDfs(board, subword, i, j-1, visited))
                return true;
        visited[i][j] = false;
        return false;
    }
}
