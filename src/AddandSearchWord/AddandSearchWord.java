package AddandSearchWord;

import java.util.Map;

/**
 * Created by Siming on 11/7/15.
 */
public class AddandSearchWord {
    private TrieNode root;

    public AddandSearchWord()
    {
        root = new TrieNode();
    }

    public void addWord(String word)
    {
        Map<Character, TrieNode> children = root.children;

        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);

            TrieNode t = null;
            if (children.containsKey(c))
            {
                t = children.get(c);
            }
            else
            {
                t = new TrieNode(c);
                children.put(c, t);
            }

            children = t.children;

            if (i == word.length() - 1)
            {
                t.isLeaf = true;
            }
        }
    }

//    public boolean search(String word)
//    {
//
//    }
//
//    public boolean dfs(Map<Character, TrieNode> children, String word, int start)
//    {
//
//    }
}
