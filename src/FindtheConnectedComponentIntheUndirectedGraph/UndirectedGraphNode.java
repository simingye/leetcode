package FindtheConnectedComponentIntheUndirectedGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/5/16.
 */
public class UndirectedGraphNode
{
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x)
    {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
