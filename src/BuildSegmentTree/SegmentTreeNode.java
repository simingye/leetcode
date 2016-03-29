package BuildSegmentTree;

/**
 * Created by SimingYe on 2/21/16.
 */
public class SegmentTreeNode
{
    public int start;
    public int end;
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public SegmentTreeNode(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
}
