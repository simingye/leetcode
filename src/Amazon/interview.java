package Amazon;

import java.util.Arrays;

/**
 * Created by SimingYe on 2/19/16.
 */
public class interview
{
    public static ContainerWeights findOptimalWeights(double capacity, double[] weights, int numContainers)
    {
        ContainerWeights result = new ContainerWeights();
        double best = Double.MIN_VALUE;

        Arrays.sort(weights);

        int i = 0;
        int j = numContainers-1;

        while (i < j)
        {
            double sum = weights[i] + weights[j];
            double diff = sum - capacity;

            if (diff == 0)
            {
                result.first = weights[i];
                result.second = weights[j];
                return result;
            }
            else if (diff > 0)
            {
                j--;
            }
            else
            {
                if (best < sum)
                {
                    best = sum;
                    result.first = weights[i];
                    result.second = weights[j];
                }

                i++;
            }
        }

        return result;
    }
}
