package NumberOfIslandsII;

import CountTriangles.CountTriangles;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/5/16.
 */
public class NumberOfIslandsII
{
    int count = 0;

    public List<Integer> numIsland2(int n, int m, Point[] operators)
    {
        List<Integer> result = new ArrayList<>();

        if (operators == null || operators.length == 0)
            return result;

        int[][] island = new int[n][m];
        UnionFind uf = new UnionFind(n, m);

        for (int i = 0; i < operators.length; i++)
        {
            int x = operators[i].x;
            int y = operators[i].y;

            if (island[x][y] != 1)
            {
                count++;
                island[x][y] = 1;

                helper(x, y, n, m, uf, island);
            }

            result.add(count);
        }

        return result;
    }

    public void helper(int x, int y, int n, int m, UnionFind uf, int[][] island)
    {
        int index = x * m + y;

        int top_x = x - 1;
        int top_y = y;
        int left_x = x;
        int left_y = y - 1;
        int right_x = x;
        int right_y = y + 1;
        int bot_x = x + 1;
        int bot_y = y;

        if (top_x >= 0 && top_x < n && top_y >= 0 && top_y < m && island[top_x][top_y] == 1)
        {
            int temp = top_x * m + top_y;
            int fa1 = uf.find(index);
            int fa2 = uf.find(temp);

            if (fa1 != fa2)
            {
                count--;
                uf.union(index, temp);
            }
        }

        if (bot_x >= 0 && bot_x < n && bot_y >= 0 && bot_y < m && island[bot_x][bot_y] == 1)
        {
            int temp = bot_x * m + bot_y;
            int fa1 = uf.find(index);
            int fa2 = uf.find(temp);

            if (fa1 != fa2)
            {
                count--;
                uf.union(index, temp);
            }
        }

        if (left_x >= 0 && left_x < n && left_y >= 0 && left_y < m && island[left_x][left_y] == 1)
        {
            int temp = left_x * m + left_y;
            int fa1 = uf.find(index);
            int fa2 = uf.find(temp);

            if (fa1 != fa2)
            {
                count--;
                uf.union(index, temp);
            }
        }

        if (right_x >= 0 && right_x < n && right_y >= 0 && right_y < m && island[right_x][right_y] == 1)
        {
            int temp = right_x * m + right_y;
            int fa1 = uf.find(index);
            int fa2 = uf.find(temp);

            if (fa1 != fa2)
            {
                count--;
                uf.union(index, temp);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslandsII test = new NumberOfIslandsII();
        Point one = new Point(1,1);
        Point two = new Point(0,1);
        Point three = new Point(3,3);
        Point four = new Point(3,4);
        Point[] operator = {one, two, three, four};
        test.numIsland2(4, 5, operator);
    }
}
