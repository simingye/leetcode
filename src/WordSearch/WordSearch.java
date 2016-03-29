package WordSearch;

/**
 * Created by Siming on 9/29/15.
 */
public class WordSearch
{
    public boolean exist(char[][] board, String word)
    {
        if (board == null || board.length == 0)
            return false;

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (dfs(board, word, i, j, 0))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k)
    {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return false;

        if (word.charAt(k) == board[i][j])
        {
            char temp = board[i][j];
            board[i][j] = '#';

            if (k == word.length()-1)
            {
                return true;
            }
            else if (dfs(board, word, i-1, j, k+1) ||
                    dfs(board, word, i+1, j, k+1) ||
                    dfs(board, word, i, j+1, k+1) ||
                    dfs(board, word, i, j-1, k+1))
            {
                return true;
            }
            board[i][j] = temp;
        }

        return false;
    }

    public static void main(String[] args) {
        WordSearch test = new WordSearch();
        char[][] board = {{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        System.out.println(test.exist(board, "abcced"));
    }
}
