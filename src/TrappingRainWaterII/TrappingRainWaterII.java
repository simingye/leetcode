package TrappingRainWaterII;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by SimingYe on 3/6/16.
 */
public class TrappingRainWaterII
{
    public int trapRainWater(int[][] heights)
    {
        int result = 0;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        if (heights == null || heights.length == 0)
            return 0;

        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
            public int compare(Cell c1, Cell c2) {
                if (c1.h > c2.h)
                {
                    return 1;
                }
                else if (c1.h < c2.h)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        });

        int n = heights.length;
        int m = heights[0].length;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++)
        {
            pq.add(new Cell(i, 0, heights[i][0]));
            pq.add(new Cell(i, m-1, heights[i][m-1]));
            visited[i][0] = 1;
            visited[i][m-1] = 1;
        }

        for (int j = 0; j < m; j++)
        {
            pq.add(new Cell(0, j, heights[0][j]));
            pq.add(new Cell(n-1, j, heights[n-1][j]));
            visited[0][j] = 1;
            visited[n-1][j] = 1;
        }

        while (!pq.isEmpty())
        {
            Cell now = pq.poll();

            for (int i = 0; i < 4; i++)
            {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < n && nx >=0 && ny < m && ny >= 0 && visited[nx][ny] != 1)
                {
                    visited[nx][ny] = 1;
                    pq.add(new Cell(nx, ny, Math.max(heights[nx][ny], now.h)));
                    result += Math.max(0, now.h - heights[nx][ny]);
                }
            }
        }

        return result;
    }
}
