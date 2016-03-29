package FacebookInterview;

import java.util.*;

/**
 * Created by Siming on 9/26/15.
 */
public class ShowBinaryTreeInVertical
{
    public String showTree(TreeNode root)
    {
        if (root == null)
            return "";

        Map<String, String> result = new HashMap<String, String>();
//        Map<String, String> map = new TreeMap<>();
        int current = 0;

        dfs(root, current, result);

        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(result.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return Integer.parseInt(o1.getValue()) - Integer.parseInt(o2.getValue());
            }
        });

        String res = "";
        String temp = list.get(0).getValue();
        for (Map.Entry<String, String> mapping : list)
        {
            if (!mapping.getValue().equalsIgnoreCase(temp))
            {
                res += "\n" + mapping.getKey();
                temp = mapping.getValue();
            }
            else
            {
                res += mapping.getKey();
            }
        }
//        String res = "";
//        String temp = map.keySet().iterator().next();
//        for (String element : map.keySet())
//        {
//            if (!element.equalsIgnoreCase(temp))
//            {
//                res += "\n" + element;
//                temp = map.get(element);
//            }
//            else
//            {
//                res += element;
//            }
//        }

        return res;
    }

    public void dfs(TreeNode node, int current, Map<String, String> result)
    {
        result.put(String.valueOf(node.val), String.valueOf(current));

        if (node.left == null && node.right == null)
            return;

        if (node.left != null)
        {
            dfs(node.left, current - 1, result);
        }

        if (node.right != null)
        {
            dfs(node.right, current + 1, result);
        }
    }

    public static void main(String[] args) {
        ShowBinaryTreeInVertical test = new ShowBinaryTreeInVertical();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node4.left = node6;

        System.out.println(test.showTree(root));
    }
}
