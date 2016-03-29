package ValidSudoku;

import java.util.ArrayList;

/**
 * Created by Siming on 5/30/15.
 */
public class ValidSudoku
{
    public boolean isValidSudoku (char[][] board)
    {
        ArrayList<Character> row;
        ArrayList<Character> colum;

        //validate rows and colums
        for (int i = 0; i < 9; i++)
        {
            row = new ArrayList<Character>();
            colum = new ArrayList<Character>();

            for (int j = 0; j < 9; j++)
            {
                if (row.contains(board[i][j]) && board[i][j] != '.')
                {
                    return false;
                }
                else
                {
                    row.add(board[i][j]);
                }

                if (colum.contains(board[j][i]) && board[j][i] != '.')
                {
                    return false;
                }
                else
                {
                    colum.add(board[j][i]);
                }
            }

        }


        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                ArrayList<Character> block = new ArrayList<Character>();

                for (int m = i * 3; m < i * 3 + 3; m++)
                {
                    for (int n = j * 3; n < j * 3 + 3; n++)
                    {
                        if (block.contains(board[m][n]) && board[m][n] != '.')
                        {
                            return false;
                        }
                        else
                        {
                            block.add(board[m][n]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
