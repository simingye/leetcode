package RepeatedDNASequences;

import java.util.*;

/**
 * Created by Siming on 10/31/15.
 */
public class RepeatedDNASequences
{
    public List<String> findrepeatedDnaSequences(String s)
    {
        List<String> result = new ArrayList<>();

        if (s == null || s.length() <= 10)
            return result;

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        Set<Integer> temp = new HashSet<>();
        Set<Integer> added = new HashSet<>();

        int hash = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (i < 9)
            {
                hash = (hash << 2) + map.get(s.charAt(i));
            }
            else
            {
                hash = (hash << 2) + map.get(s.charAt(i));
                hash = hash & 0x000fffff;

                if (temp.contains(hash) && !added.contains(hash))
                {
                    result.add(s.substring(i - 9, i + 1));
                    added.add(hash);
                }
                else
                {
                    temp.add(hash);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        RepeatedDNASequences test = new RepeatedDNASequences();
        System.out.println(test.findrepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
