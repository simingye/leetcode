package BuildingOutline;

import java.util.*;

/**
 * Created by SimingYe on 3/8/16.
 */
public class BuildingOutline
{
    class PointComparator implements Comparator<Point>
    {
        public int compare(Point p1, Point p2) {
            if (p1.time != p2.time)
            {
                return Integer.compare(p1.time, p2.time);
            }

            if (p1.flag == 0 && p2.flag == 0)
            {
                return Integer.compare(p2.height, p1.height);
            }

            if (p1.flag == 1 && p2.flag == 1)
            {
                return Integer.compare(p1.height, p2.height);
            }

            return p1.flag == 0 ? -1 : 1;
        }
    }

    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (buildings == null || buildings.length == 0)
            return result;

        List<Point> points = new ArrayList<>();

        for (int i = 0; i < buildings.length; i++)
        {
            Point p1 = new Point(buildings[i][0], buildings[i][2], 0);
            Point p2 = new Point(buildings[i][1], buildings[i][2], 1);
            points.add(p1);
            points.add(p2);
        }

        Collections.sort(points, new PointComparator());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(buildings.length, Collections.reverseOrder());

        ArrayList<Integer> temp = null;
        for (Point p : points)
        {
            if (p.flag == 0)
            {
                if (maxHeap.isEmpty() || p.height > maxHeap.peek())
                {
                    temp = new ArrayList<>(Arrays.asList(p.time, p.height));
                    result.add(temp);
                }
                maxHeap.add(p.height);
            }
            else
            {
                maxHeap.remove(p.height);
                if (maxHeap.isEmpty() || p.height > maxHeap.peek())
                {
                    if (maxHeap.isEmpty())
                    {
                        temp = new ArrayList<>(Arrays.asList(p.time, 0));
                    }
                    else
                    {
                        temp = new ArrayList<>(Arrays.asList(p.time, maxHeap.peek()));
                    }
                    result.add(temp);
                }
            }
        }

        return output(result);
    }

    ArrayList<ArrayList<Integer>> output(ArrayList<ArrayList<Integer>> res) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (res.size() > 0) {
            int pre = res.get(0).get(0);
            int height = res.get(0).get(1);
            for (int i = 1; i < res.size(); i++) {
                ArrayList<Integer> now = new ArrayList<Integer>();
                int id = res.get(i).get(0);
                if (height > 0) {
                    now.add(pre);
                    now.add(id);
                    now.add(height);
                    ans.add(now);
                }
                pre = id;
                height = res.get(i).get(1);
            }
        }
        return ans;
    }
}
