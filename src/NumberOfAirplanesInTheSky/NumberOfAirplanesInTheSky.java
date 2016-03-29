package NumberOfAirplanesInTheSky;

import java.util.*;

/**
 * Created by SimingYe on 2/27/16.
 */
public class NumberOfAirplanesInTheSky
{
    public int countOfAirplanes(List<Interval> airplanes)
    {
        if (airplanes == null || airplanes.isEmpty())
            return 0;

        int count = 0;
        int result = Integer.MIN_VALUE;
        List<Point> list = new ArrayList<>();
        for (Interval element : airplanes)
        {
            list.add(new Point(element.start, 1));
            list.add(new Point(element.end, 0));
        }

        Collections.sort(list, Point.c);

        for (Point p : list)
        {
            if (p.flag == 1)
                count++;
            else
                count--;

            result = Math.max(result, count);
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfAirplanesInTheSky test = new NumberOfAirplanesInTheSky();
        List<Interval> airplanes = new ArrayList<>();
        airplanes.add(new Interval(1,4));
        airplanes.add(new Interval(1,4));
        airplanes.add(new Interval(1,4));

        System.out.println(test.countOfAirplanes(airplanes));
    }
}
