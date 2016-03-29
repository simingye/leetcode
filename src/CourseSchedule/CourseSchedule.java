package CourseSchedule;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Siming on 11/11/15.
 */
public class CourseSchedule
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        if (prerequisites == null)
            return false;

        int length = prerequisites.length;

        if (numCourses == 0 || length == 0)
            return true;

        int[] pcounter = new int[numCourses];
        for (int i = 0; i < length; i++)
        {
            pcounter[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
        {
            if (pcounter[i] == 0)
            {
                queue.add(i);
            }
        }

        int numNoPre = queue.size();

        while (!queue.isEmpty())
        {
            int top = queue.poll();

            for (int i = 0; i < length; i++)
            {
                if (prerequisites[i][1] == top)
                {
                    pcounter[prerequisites[i][0]]--;
                    if (pcounter[prerequisites[i][0]] == 0)
                    {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }

        return numNoPre == numCourses;
    }
}
