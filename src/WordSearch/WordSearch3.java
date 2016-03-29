package WordSearch;

/**
 * Created by SimingYe on 2/22/16.
 */
public class WordSearch3
{
    public boolean exist(char[][] board, String word)
    {
        if (board == null || board.length == 0 || board[0].length == 0)
            return false;

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                boolean res = false;

                if (board[i][j] == word.charAt(0))
                {
                    res = bfs(board, i, j, 0, word);
                }

                if (res == true)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean bfs(char[][] board, int x, int y, int index, String word)
    {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || index >= word.length())
            return false;

        if (board[x][y] == word.charAt(index))
        {
            char temp = board[x][y];
            board[x][y] = '#';

            if (index == word.length() - 1)
            {
                return true;
            }

            if (bfs(board, x+1, y, index+1, word)
                    || bfs(board, x-1, y, index+1, word)
                    || bfs(board, x, y+1, index+1, word)
                    || bfs(board, x, y-1, index+1, word))
            {
                return true;
            }

            board[x][y] = temp;
        }
        else
        {
            return false;
        }

        return false;
    }
}
