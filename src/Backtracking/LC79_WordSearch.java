package Backtracking;

public class LC79_WordSearch {
    /*
        深度优先搜索
     */
    public boolean dfs(char[][] board, int[][] visited, int i, int j, char[] word, int h) {
        if (h == word.length) {
            return true;
        }
        int x = board.length;
        int y = board[0].length;
        if (i < 0 || i == x || j < 0 || j == y || visited[i][j] == 1 || word[h] != board[i][j])
            return false;
        visited[i][j] = 1;
        if (dfs(board, visited, i - 1, j, word, h + 1) ||
                dfs(board, visited, i + 1, j, word, h + 1)||
                dfs(board, visited, i, j - 1, word, h + 1)||
                dfs(board, visited, i, j + 1, word, h + 1)
                ) {
            return true;
        }
        visited[i][j] = 0;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        char[] ch_word = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int[][] visited = new int[board.length][board[i].length];
                if (board[i][j] == ch_word[0]) {
                    if (dfs(board, visited, i, j, ch_word, 0))
                        return true;
                }
            }
        }
        return false;
    }
}
