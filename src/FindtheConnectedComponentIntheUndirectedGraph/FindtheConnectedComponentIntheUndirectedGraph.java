package FindtheConnectedComponentIntheUndirectedGraph;

import java.util.*;

/**
 * Created by SimingYe on 3/5/16.
 */
public class FindtheConnectedComponentIntheUndirectedGraph
{
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (nodes == null || nodes.isEmpty())
            return result;

        Map<UndirectedGraphNode, Boolean> map = new HashMap<>();

        for (UndirectedGraphNode node : nodes)
        {
            List<Integer> list = bfs(node, map);
            if (!list.isEmpty() && list != null)
            {
                result.add(list);
            }
        }

        return result;
    }

    public List<Integer> bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> map)
    {
        List<Integer> res = new ArrayList<>();

        if (map.containsKey(node))
            return res;

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty())
        {
            UndirectedGraphNode tempNode = queue.poll();

            if (!map.containsKey(tempNode))
            {
                res.add(tempNode.label);
                map.put(tempNode, true);
                List<UndirectedGraphNode> neighbors = tempNode.neighbors;
                for (UndirectedGraphNode n : neighbors)
                {
                    queue.add(n);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
