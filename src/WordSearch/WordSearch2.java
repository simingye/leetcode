package WordSearch;

/**
 * Created by SimingYe on 2/10/16.
 */
public class WordSearch2
{
    public boolean exist(char[][] board, String word)
    {
        if (board == null || board.length == 0)
            return false;

        boolean result = false;

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    result = helper(board, word, i, j, 0);

                    if (result == true)
                    {
                        return result;
                    }
                }
            }
        }

        return result;
    }

    public boolean helper(char[][] board, String word, int x, int y, int index)
    {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return false;

        if (board[x][y] == word.charAt(index))
        {
            char temp = board[x][y];
            board[x][y] = '#';

            if (index == word.length() - 1)
            {
                return true;
            }
            else if (helper(board, word, x+1, y, index+1)
                    || helper(board, word, x, y+1, index+1)
                    || helper(board, word, x-1, y, index+1)
                    || helper(board, word, x, y-1, index+1))
            {
                return true;
            }

            board[x][y] = temp;
        }

        return false;
    }

    public static void main(String[] args) {
        WordSearch2 test = new WordSearch2();
        char[][] board = {{'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}};
        System.out.println(test.exist(board, "AAB"));
    }
}
