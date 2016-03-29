package ImplementTrie;

import java.util.HashMap;

/**
 * Created by Siming on 11/5/15.
 */
public class TrieNode
{
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode()
    {

    }

    public TrieNode(char c)
    {
        this.c = c;
    }
}
