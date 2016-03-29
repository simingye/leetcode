package Interview;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Created by Siming on 11/14/15.
 */
public class bfsGraph
{
    public void bfs(int[][] graph, int node)
    {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < 10; i++)
        {
            map.put(i, Boolean.FALSE);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty())
        {
            Queue<Integer> tempQueue = new LinkedList<>();

            while (!queue.isEmpty())
            {
                int n = queue.poll();
                map.put(n, Boolean.TRUE);
                System.out.print(n + " -> ");

                if (getNeighbors(n, graph).length > 0)
                {
                    for (int i = 0; i < getNeighbors(n, graph).length; i++)
                    {
                        if (map.get(getNeighbors(n, graph)[i]) == Boolean.FALSE && getNeighbors(n, graph)[i] > 0)
                        {
                            tempQueue.add(getNeighbors(n, graph)[i]);
                            System.out.print(getNeighbors(n, graph)[i] + " ");
                        }
                    }
                }
            }
            System.out.println("");
            queue = tempQueue;
        }
    }

    public int[] getNeighbors(int node, int[][] graph)
    {
        int[] neighbors = new int[graph.length];

        for (int i : neighbors)
        {
            i = -1;
        }

        int count = 0;
        for (int i = 0; i < graph.length; i++)
        {
            if (graph[i][0] == node)
            {
                neighbors[count] = graph[i][1];
                count++;
            }
        }


        return neighbors;
    }

    public static void main(String[] args) {
        bfsGraph test = new bfsGraph();
        int[][] graph = { {0,1}, {0,6}, {0,8}, {1,4}, {1,6}, {1,9}, {2,4}, {2,6}, {3,4}, {3,5},
        {3,8}, {4,5}, {4,9}, {7,8}, {7,9} };
        test.bfs(graph, 0);
    }
}
