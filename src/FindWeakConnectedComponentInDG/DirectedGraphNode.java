package FindWeakConnectedComponentInDG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/4/16.
 */
public class DirectedGraphNode
{
    int label;
    List<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x)
    {
        label = x;
        neighbors = new ArrayList<>();
    }
}
