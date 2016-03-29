package GraphValidTree;

/**
 * Created by SimingYe on 2/29/16.
 */
public class GraphValidTree2
{
    private int[] father;

    public boolean validTree(int n, int[][] edges)
    {
        if (n - 1 != edges.length)
            return false;

        father = new int[n];
        for (int i = 0; i < n; i++)
        {
            father[i] = i;
        }

        for (int i = 0; i < edges.length; i++)
        {
            if (find(edges[i][0]) == find(edges[i][1]))
            {
                return false;
            }

            union(edges[i][0], edges[i][1]);
        }

        return true;
    }

    public int find(int node)
    {
        int parent = father[node];

        if (parent == node)
        {
            return node;
        }

        father[node] = find(parent);

        return father[node];
    }

    public void union(int node1, int node2)
    {
        if (find(node1) != find(node2))
        {
            father[find(node1)] = father[find(node2)];
        }
    }
}
