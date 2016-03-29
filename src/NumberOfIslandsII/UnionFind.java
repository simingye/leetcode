package NumberOfIslandsII;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SimingYe on 3/5/16.
 */
public class UnionFind
{
    Map<Integer, Integer> map = new HashMap<>();

    UnionFind(int n, int m)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                int index = PointToInt(i, j, m);
                map.put(index, index);
            }
        }
    }

    public int find(int x)
    {
        int parent = map.get(x);

        while (parent != map.get(parent))
        {
            parent = map.get(parent);
        }

        return parent;
    }

    public int compress_find(int x)
    {
        int parent = map.get(x);

        while (parent != map.get(x))
        {
            parent = map.get(parent);
        }

        int temp = -1;
        int father = x;
        while (father != map.get(father))
        {
            temp = map.get(father);
            map.put(father, parent);
            father = temp;
        }

        return parent;
    }

    public void union(int x, int y)
    {
        int fa_x = find(x);
        int fa_y = find(y);

        if (fa_x != fa_y)
        {
            map.put(fa_x, fa_y);
        }
    }

    public int PointToInt(int i, int j, int m)
    {
        return i * m + j;
    }
}
