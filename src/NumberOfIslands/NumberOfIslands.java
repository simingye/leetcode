package NumberOfIslands;

/**
 * Created by Siming on 10/10/15.
 */
public class NumberOfIslands
{
    public int numIslands(char[][] grid)
    {
        if (grid == null || grid.length == 0)
            return 0;

        int count = 0;

        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1')
                {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int i, int j)
    {
        if (i >= grid.length || i < 0 || j < 0 || j >= grid[0].length)
            return;

        if (grid[i][j] == '1')
        {
            grid[i][j] = '#';
        }
        else
        {
            return;
        }

        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }

    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(test.numIslands(grid));
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                System.out.print(grid[i][j]);
            }
            System.out.println("");
        }
    }
}
