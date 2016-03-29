package WordSearchII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/6/16.
 */
public class WordSearchII
{
    public List<String> wordSearchII(char[][] board, List<String> words)
    {
        List<String> result = new ArrayList<>();

        if (words == null || words.isEmpty())
            return result;

        TrieNode root = new TrieNode();
        TrieTree trieTree = new TrieTree(root);
        for (String word : words)
        {
            trieTree.insert(word);
        }

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                search(board, i, j, root, result);
            }
        }

        return result;
    }

    public int[] dx = {1, 0, -1, 0};
    public int[] dy = {0, 1, 0, -1};

    public void search(char[][] board, int x, int y, TrieNode root, List<String> result)
    {
        if (root.isString)
        {
            if (!result.contains(root.s))
            {
                result.add(root.s);
            }
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
        {
            return;
        }

        if (root.subTree.containsKey(board[x][y]))
        {
            for (int i = 0; i < 4; i++)
            {
                char now = board[x][y];
                board[x][y] = 0;
                search(board, x+dx[i], y+dy[i], root.subTree.get(now), result);
                board[x][y] = now;
            }
        }
    }
}
