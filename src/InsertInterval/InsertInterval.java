package InsertInterval;

import AddBinary.AddBinary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/25/16.
 */
public class InsertInterval
{
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval)
    {
        ArrayList<Interval> result = new ArrayList<>();

        if (intervals == null || intervals.isEmpty() || newInterval == null)
            return result;


        int insertPos = 0;

        for (Interval interval : intervals)
        {
            if (interval.end < newInterval.start)
            {
                result.add(interval);
                insertPos++;
            }
            else if (interval.start > newInterval.end)
            {
                result.add(interval);
            }
            else
            {
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }

        result.add(insertPos, newInterval);

        return result;
    }
}
