package AddandSearchWord;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siming on 11/7/15.
 */
public class TrieNode
{
    char c;
    boolean isLeaf;
    Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode(){}

    public TrieNode(char c)
    {
        this.c = c;
    }
}
