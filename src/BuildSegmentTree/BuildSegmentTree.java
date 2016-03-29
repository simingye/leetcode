package BuildSegmentTree;

/**
 * Created by SimingYe on 2/21/16.
 */
public class BuildSegmentTree
{
    public SegmentTreeNode build(int start, int end)
    {
        if (start > end)
            return null;

        SegmentTreeNode root = new SegmentTreeNode(start, end);

        if (start != end)
        {
            root.left = build(start, (start + end) / 2);
            root.right = build((start + end) / 2 + 1, end);
        }

        return root;
    }
}
