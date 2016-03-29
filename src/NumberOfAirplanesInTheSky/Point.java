package NumberOfAirplanesInTheSky;

import java.util.Comparator;

/**
 * Created by SimingYe on 2/28/16.
 */
public class Point
{
    int time;
    int flag;

    Point(int t, int s)
    {
        this.time = t;
        this.flag = s;
    }

    public static Comparator<Point> c = new Comparator<Point>()
    {
        public int compare(Point o1, Point o2)
        {
            if (o1.time == o2.time)
            {
                return o1.flag - o2.flag;
            }
            else
            {
                return o1.time - o2.time;
            }
        }
    };
}
