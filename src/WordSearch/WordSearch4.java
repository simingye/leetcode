package WordSearch;

/**
 * Created by SimingYe on 2/29/16.
 */
public class WordSearch4
{
    public boolean exist(char[][] board, String word)
    {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                boolean result = false;

                if (board[i][j] == word.charAt(0))
                {
                    result = dfs(board, i, j, 0, word);
                }

                if (result == true)
                    return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int x, int y, int index, String word)
    {
        boolean result = false;

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || index >= word.length())
            return false;

        if (index == word.length()-1 && board[x][y] == word.charAt(index))
        {
            return true;
        }
        else if (index < word.length() && board[x][y] == word.charAt(index))
        {
            char temp = board[x][y];
            board[x][y] = '#';

            result =  dfs(board, x+1, y, index+1, word)
                    || dfs(board, x-1, y, index+1, word)
                    || dfs(board, x, y+1, index+1, word)
                    || dfs(board, x, y-1, index+1, word);

            board[x][y] = temp;
        }

        return result;
    }
}
