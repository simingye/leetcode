package WordSearchII;

/**
 * Created by SimingYe on 3/6/16.
 */
public class TrieTree
{
    TrieNode root;

    public TrieTree(TrieNode node)
    {
        root = node;
    }

    public void insert(String s)
    {
        TrieNode now = root;
        for (int i = 0; i < s.length(); i++)
        {
            if (!now.subTree.containsKey(s.charAt(i)))
            {
                now.subTree.put(s.charAt(i), new TrieNode());
            }
            now = now.subTree.get(s.charAt(i));
        }
        now.s = s;
        now.isString = true;
    }

    public boolean find(String s)
    {
        TrieNode now = root;

        for (int i = 0; i < s.length(); i++)
        {
            if (!now.subTree.containsKey(s.charAt(i)))
            {
                return false;
            }

            now = now.subTree.get(s.charAt(i));
        }

        return now.isString;
    }
}
