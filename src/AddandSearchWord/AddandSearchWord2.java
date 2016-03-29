package AddandSearchWord;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SimingYe on 2/29/16.
 */

public class AddandSearchWord2
{
    class TrieNode
    {
        public Map<Character, TrieNode> children;
        public boolean hasWord;

        public TrieNode()
        {
            children = new HashMap<>();
            hasWord = false;
        }
    }

    private TrieNode root = new TrieNode();

    public void addWord(String word)
    {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++)
        {
            if (node.children.containsKey(word.charAt(i)))
            {
                node = node.children.get(word.charAt(i));
                continue;
            }
            else
            {
                node.children.put(word.charAt(i), new TrieNode());
                node = node.children.get(word.charAt(i));
            }
        }

        node.hasWord = true;
    }

    public boolean search(String word)
    {
        return find(word, 0, root);
    }

    public boolean find(String word, int index, TrieNode node)
    {
        if (index == word.length())
        {
            if(node.children.size()==0)
                return true;
            else
                return false;
        }

        char c = word.charAt(index);
        if (node.children.containsKey(c))
        {
            if (index == word.length()-1 && node.children.get(c).hasWord)
            {
                return true;
            }

            return find(word, index+1, node.children.get(c));
        }
        else if (c == '.')
        {
            boolean result = false;
            for (Map.Entry<Character, TrieNode> child : node.children.entrySet())
            {
                if (index == word.length()-1 && child.getValue().hasWord)
                {
                    return true;
                }

                if (find(word, index+1, child.getValue()))
                {
                    result = true;
                }
            }

            return result;
        }
        else
        {
            return false;
        }
    }
}
