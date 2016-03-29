package Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by SimingYe on 2/18/16.
 */
public class KClosestPoints
{
    public CPoint[] findClose(CPoint[] arr, int k)
    {
        if (k <= 0)
            return null;

        PriorityQueue<CPoint> maxHeap = new PriorityQueue<>(k, new Comparator<CPoint>() {

            public int compare(CPoint p1, CPoint p2) {
                double distance1 = p1.x * p1.x + p1.y * p1.y;
                double distance2 = p2.x * p2.x + p2.y * p2.y;

                if (distance1 > distance2)
                {
                    return -1;
                }
                else if (distance1 < distance2)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        });

        for (int i = 0; i < arr.length; i++)
        {
            if (maxHeap.size() <= k)
            {
                maxHeap.add(arr[i]);
            }
            else
            {
                if (arr[i].x * arr[i].x + arr[i].y * arr[i].y < maxHeap.peek().x * maxHeap.peek().x + maxHeap.peek().y * maxHeap.peek().y)
                {
                    maxHeap.poll();
                    maxHeap.add(arr[i]);
                }
            }
        }

        CPoint[] result = new CPoint[k];

        for (int i = 0; i < k; i++)
        {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        CPoint p1 = new CPoint(0.0, 1.0);
        CPoint p2 = new CPoint(0.0, 2.0);
        CPoint p3 = new CPoint(0.0, 3.0);
        CPoint p4 = new CPoint(0.0, 4.0);
        CPoint p5 = new CPoint(0.0, 5.0);
        CPoint p6 = new CPoint(0.0, 6.0);
        CPoint p7 = new CPoint(0.0, 7.0);
        CPoint p8 = new CPoint(0.0, 8.0);

        CPoint[] arr = {p1,p2,p3,p4,p5,p6,p7,p8};

        KClosestPoints test = new KClosestPoints();
        test.findClose(arr, 6);
    }
}
