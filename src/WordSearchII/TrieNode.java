package WordSearchII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SimingYe on 3/6/16.
 */
public class TrieNode
{
    String s;
    boolean isString;
    Map<Character, TrieNode> subTree;
    public TrieNode()
    {
        isString = false;
        subTree = new HashMap<>();
        s = "";
    }
}
