package FindWeakConnectedComponentInDG;

import java.util.*;

/**
 * Created by SimingYe on 3/4/16.
 */
public class FindWeakConnectedComponentInDG
{
    class UnionFind
    {
        Map<Integer, Integer> father = new HashMap<>();
        UnionFind(HashSet<Integer> hashSet)
        {
            for (Integer now : hashSet)
            {
                father.put(now, now);
            }
        }

        int find(int x)
        {
            int parent = father.get(x);
            while (parent != father.get(parent))
            {
                parent = father.get(parent);
            }

            return parent;
        }

        void union(int x, int y)
        {
            int fa_x = find(x);
            int fa_y = find(y);

            if (fa_x != fa_y)
            {
                father.put(fa_x, fa_y);
            }
        }
    }

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nodes == null || nodes.isEmpty())
            return result;

        HashSet<Integer> set = new HashSet<>();
        for (DirectedGraphNode now : nodes)
        {
            set.add(now.label);
            for (DirectedGraphNode neighbor : now.neighbors)
            {
                set.add(neighbor.label);
            }
        }

        UnionFind uf = new UnionFind(set);

        for (DirectedGraphNode now : nodes)
        {
            for (DirectedGraphNode neighbor : now.neighbors)
            {
                int fnow = uf.find(now.label);
                int fneighbor = uf.find(neighbor.label);
                if (fnow != fneighbor)
                {
                    uf.union(now.label, neighbor.label);
                }
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i : set)
        {
            int fa = uf.find(i);
            if (!map.containsKey(fa))
            {
                map.put(fa, new ArrayList<Integer>());
            }
            List<Integer> now = map.get(fa);
            now.add(i);
            map.put(fa, now);
        }

        for (List<Integer> now : map.values())
        {
            Collections.sort(now);
            result.add(now);
        }

        return result;
    }
}
